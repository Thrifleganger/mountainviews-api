package com.thrifleganger.mountainviews.api.service;

import com.thrifleganger.mountainviews.api.entity.MountainRange;
import com.thrifleganger.mountainviews.api.repository.MountainRangeRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MountainRangeService {

  private final MountainRangeRepository mountainRangeRepository;

  public List<MountainRange> findAll() {
    return mountainRangeRepository.findAll();
  }

  public MountainRange findById(@NonNull UUID id) {
    return mountainRangeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }

  public Optional<MountainRange> findByName(@NonNull String name) {
    return mountainRangeRepository.findByName(name).stream().findFirst();
  }
}
