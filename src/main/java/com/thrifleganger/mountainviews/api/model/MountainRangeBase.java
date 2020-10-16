package com.thrifleganger.mountainviews.api.model;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class MountainRangeBase {
  private UUID id;
  private String name;
  private Integer numberOfPeaks;
}
