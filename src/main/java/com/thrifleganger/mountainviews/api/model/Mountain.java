package com.thrifleganger.mountainviews.api.model;

import com.thrifleganger.mountainviews.api.model.sub.Location;
import com.thrifleganger.mountainviews.api.model.sub.Topography;
import com.thrifleganger.mountainviews.api.model.sub.Unit;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class Mountain {

  private UUID id;
  private String name;
  private String irishName;
  private Location location;
  private Topography topography;
  private String description;
  private String mountainviewsLink;
  private CountyBase county;
  private Unit unit;
  private MountainRangeBase mountainRange;

  public Mountain setWhat3Words(String text) {
    this.location.setWhat3words(text);
    return this;
  }

  public Mountain setNearestLocation(String text) {
    this.location.setNearestLocation(text);
    return this;
  }

  public Mountain setCountry(String text) {
    this.county.setCountry(text);
    return this;
  }
}
