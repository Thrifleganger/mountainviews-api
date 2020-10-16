package com.thrifleganger.mountainviews.api.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

import java.util.UUID;

@Getter
@Builder
public class MountainRange extends RepresentationModel<MountainRange> {
  private UUID id;
  private String name;
  private Integer numberOfPeaks;
}
