package com.thrifleganger.mountainviews.api.service;

import com.thrifleganger.mountainviews.api.model.County;
import com.thrifleganger.mountainviews.api.model.CountyExpanded;
import com.thrifleganger.mountainviews.api.repository.CountyRepository;
import com.thrifleganger.mountainviews.api.transformer.CountyBaseEntityToModelTransformer;
import com.thrifleganger.mountainviews.api.transformer.CountyExpandedTransformer;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CountyService {

  private final CountyRepository countyRepository;
  private final CountyBaseEntityToModelTransformer countyBaseEntityToModelTransformer;
  private final CountyExpandedTransformer countyExpandedTransformer;


  public Page<County> findAll(@NonNull PageRequest pageRequest) {
    return countyRepository.findAll(pageRequest)
      .map(countyBaseEntityToModelTransformer::transform);
  }

  public CountyExpanded findById(@NonNull UUID id) {
    return countyRepository.findById(id)
      .map(countyExpandedTransformer::transform)
      .orElseThrow(EntityNotFoundException::new);
  }
}
