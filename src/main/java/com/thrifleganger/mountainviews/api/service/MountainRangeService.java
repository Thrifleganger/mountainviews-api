package com.thrifleganger.mountainviews.api.service;

import com.thrifleganger.mountainviews.api.model.MountainRange;
import com.thrifleganger.mountainviews.api.model.MountainRangeExpanded;
import com.thrifleganger.mountainviews.api.repository.MountainRangeRepository;
import com.thrifleganger.mountainviews.api.transformer.MountainRangeEntityToModelTransformer;
import com.thrifleganger.mountainviews.api.transformer.MountainRangeExpandedTransformer;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MountainRangeService {

  private final MountainRangeRepository mountainRangeRepository;
  private final MountainRangeEntityToModelTransformer mountainRangeEntityToModelTransformer;
  private final MountainRangeExpandedTransformer mountainRangeExpandedTransformer;

  public Page<MountainRange> findAll(@NonNull PageRequest pageRequest) {
    return mountainRangeRepository.findAll(pageRequest)
      .map(mountainRangeEntityToModelTransformer::transform);
  }

  public MountainRangeExpanded findById(@NonNull UUID id) {
    return mountainRangeRepository.findById(id)
      .map(mountainRangeExpandedTransformer::transform)
      .orElseThrow(EntityNotFoundException::new);
  }
}
