package com.thrifleganger.mountainviews.api.service;

import com.thrifleganger.mountainviews.api.entity.CountyEntity;
import com.thrifleganger.mountainviews.api.repository.CountyRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CountyService {

  private final CountyRepository countyRepository;

  public List<CountyEntity> findAll() {
    return countyRepository.findAll();
  }

  public CountyEntity findById(@NonNull UUID id) {
    return countyRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }

  public Optional<CountyEntity> findByName(@NonNull String name) {
    return countyRepository.findByName(name).stream().findFirst();
  }
}
