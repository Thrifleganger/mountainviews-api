package com.thrifleganger.mountainviews.api.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Builder
public class CountyBase {
  private UUID id;
  private String name;
  private String province;
  @Setter
  private String country;
}
