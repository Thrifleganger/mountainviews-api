package com.thrifleganger.mountainviews.api.model.sub;

import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Builder
public class MountainSummary extends RepresentationModel<MountainSummary> {

  private String name;
  private Double elevation;
}
