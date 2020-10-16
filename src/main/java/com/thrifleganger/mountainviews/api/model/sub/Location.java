package com.thrifleganger.mountainviews.api.model.sub;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class Location {
  private String latitude;
  private String longitude;
  private String easting;
  private String northing;
  private String gridReference;
  private Integer osiSheetNumber;
  @Setter
  private String what3words;
  @Setter
  private String nearestLocation;
}
