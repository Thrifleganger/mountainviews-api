package com.thrifleganger.mountainviews.api.model;

import com.thrifleganger.mountainviews.api.model.sub.Location;
import com.thrifleganger.mountainviews.api.model.sub.Topography;
import com.thrifleganger.mountainviews.api.model.sub.Unit;
import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

import java.util.UUID;

@Getter
@Builder
public class Mountain extends RepresentationModel<Mountain> {

  private UUID id;
  private String name;
  private String irishName;
  private Location location;
  private Double elevation;
  private Topography topography;
  private String description;
  private String mountainviewsLink;
  private County county;
  private String country;
  private Unit unit;
  private MountainRange mountainRange;

  public Mountain setWhat3Words(String text) {
    this.location.setWhat3words(text);
    return this;
  }

  public Mountain setNearestLocation(String text) {
    this.location.setNearestLocation(text);
    return this;
  }

  public Mountain setCountry(String text) {
    this.country = text;
    return this;
  }
}
