package com.thrifleganger.mountainviews.api.transformer;

import com.thrifleganger.mountainviews.api.controller.CountyController;
import com.thrifleganger.mountainviews.api.entity.CountyEntity;
import com.thrifleganger.mountainviews.api.entity.MountainEntity;
import com.thrifleganger.mountainviews.api.model.CountyExpanded;
import com.thrifleganger.mountainviews.api.model.sub.MountainSummary;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
@RequiredArgsConstructor
public class CountyExpandedTransformer {

  private final MountainSummaryTransformer mountainSummaryTransformer;

  public CountyExpanded transform(@NonNull CountyEntity entity) {
    CountyExpanded countyExpanded = CountyExpanded.builder()
      .id(entity.getId())
      .name(entity.getName())
      .province(entity.getProvince())
      .mountains(transformAllMountains(entity.getMountains()))
      .build();
    countyExpanded.add(linkTo(methodOn(CountyController.class).findById(entity.getId())).withSelfRel());
    return countyExpanded;
  }

  private List<MountainSummary> transformAllMountains(Set<MountainEntity> entities) {
    return entities.stream()
      .map(mountainSummaryTransformer::transform)
      .collect(Collectors.toList());
  }
}
