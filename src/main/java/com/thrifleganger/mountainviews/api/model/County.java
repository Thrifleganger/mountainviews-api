package com.thrifleganger.mountainviews.api.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

import java.util.UUID;

@Getter
@Builder
public class County extends RepresentationModel<County> {
  private UUID id;
  private String name;
  private String province;
}
