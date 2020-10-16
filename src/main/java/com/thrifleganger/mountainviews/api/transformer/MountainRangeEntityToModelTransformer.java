package com.thrifleganger.mountainviews.api.transformer;

import com.thrifleganger.mountainviews.api.controller.MountainRangeController;
import com.thrifleganger.mountainviews.api.entity.MountainRangeEntity;
import com.thrifleganger.mountainviews.api.model.MountainRange;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class MountainRangeEntityToModelTransformer {

  public MountainRange transform(@NonNull MountainRangeEntity entity) {
    MountainRange mountainRange = MountainRange.builder()
      .id(entity.getId())
      .name(entity.getName())
      .numberOfPeaks(entity.getNumberOfMountains())
      .build();
    mountainRange.add(linkTo(methodOn(MountainRangeController.class).findById(entity.getId())).withSelfRel());
    return mountainRange;
  }
}
