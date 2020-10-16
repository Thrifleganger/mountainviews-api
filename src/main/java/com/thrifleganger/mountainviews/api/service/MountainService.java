package com.thrifleganger.mountainviews.api.service;

import com.sun.istack.Nullable;
import com.thrifleganger.mountainviews.api.entity.MountainEntity;
import com.thrifleganger.mountainviews.api.model.Mountain;
import com.thrifleganger.mountainviews.api.model.What3WordsResponse;
import com.thrifleganger.mountainviews.api.repository.MountainRepository;
import com.thrifleganger.mountainviews.api.transformer.MountainEntityToModelTransformer;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MountainService {

    private final MountainRepository mountainRepository;
    private final MountainEntityToModelTransformer mountainEntityToModelTransformer;
    private final What3WordsService what3WordsService;

    public Page<Mountain> findAll(
      @Nullable Specification<MountainEntity> specification,
      @NonNull PageRequest pageRequest
    ) {
        return mountainRepository.findAll(specification, PageRequest.of(0, 10))
          .map(mountainEntityToModelTransformer::transform)
          .map(this::insertWhat3Words);
    }

    public Mountain findById(@NonNull UUID id) {
        return mountainRepository.findById(id)
          .map(mountainEntityToModelTransformer::transform)
          .map(this::insertWhat3Words)
          .orElseThrow(EntityNotFoundException::new);
    }

    private Mountain insertWhat3Words(Mountain mountain) {
      What3WordsResponse what3WordsResponse =
        what3WordsService.convert(mountain.getLocation().getLatitude(), mountain.getLocation().getLongitude());
      return mountain.setCountry(what3WordsResponse.getCountry())
        .setNearestLocation(what3WordsResponse.getNearestPlace())
        .setWhat3Words(what3WordsResponse.getWords());
    }
}
