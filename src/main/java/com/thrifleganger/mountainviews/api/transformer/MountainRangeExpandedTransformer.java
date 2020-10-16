package com.thrifleganger.mountainviews.api.transformer;

import com.thrifleganger.mountainviews.api.controller.MountainRangeController;
import com.thrifleganger.mountainviews.api.entity.MountainEntity;
import com.thrifleganger.mountainviews.api.entity.MountainRangeEntity;
import com.thrifleganger.mountainviews.api.model.MountainRangeExpanded;
import com.thrifleganger.mountainviews.api.model.sub.MountainSummary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
@RequiredArgsConstructor
public class MountainRangeExpandedTransformer {

  private final MountainSummaryTransformer mountainSummaryTransformer;

  public MountainRangeExpanded transform(MountainRangeEntity entity) {
    MountainRangeExpanded mountainRange = MountainRangeExpanded.builder()
      .id(entity.getId())
      .name(entity.getName())
      .name(entity.getName())
      .numberOfPeaks(entity.getNumberOfMountains())
      .mountains(transformAllMountains(entity.getMountains()))
      .build();
    mountainRange.add(linkTo(methodOn(MountainRangeController.class).findById(entity.getId())).withSelfRel());
    return mountainRange;
  }

  private List<MountainSummary> transformAllMountains(Set<MountainEntity> entities) {
    return entities.stream()
      .map(mountainSummaryTransformer::transform)
      .collect(Collectors.toList());
  }
}
