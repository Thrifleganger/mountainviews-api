package com.thrifleganger.mountainviews.api.transformer;

import com.thrifleganger.mountainviews.api.controller.MountainController;
import com.thrifleganger.mountainviews.api.entity.MountainEntity;
import com.thrifleganger.mountainviews.api.model.sub.MountainSummary;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class MountainSummaryTransformer {

  public MountainSummary transform(@NonNull MountainEntity entity) {
    MountainSummary mountainSummary = MountainSummary.builder()
      .name(entity.getName())
      .elevation(entity.getElevation())
      .build();
    mountainSummary.add(linkTo(methodOn(MountainController.class).findById(entity.getId())).withSelfRel());
    return mountainSummary;
  }
}
