package com.thrifleganger.mountainviews.api.transformer;

import com.thrifleganger.mountainviews.api.controller.MountainController;
import com.thrifleganger.mountainviews.api.entity.MountainEntity;
import com.thrifleganger.mountainviews.api.model.County;
import com.thrifleganger.mountainviews.api.model.Mountain;
import com.thrifleganger.mountainviews.api.model.MountainRange;
import com.thrifleganger.mountainviews.api.model.sub.Location;
import com.thrifleganger.mountainviews.api.model.sub.Topography;
import com.thrifleganger.mountainviews.api.model.sub.Unit;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.methodOn;

@Component
@RequiredArgsConstructor
public class MountainEntityToModelTransformer {

  private final CountyBaseEntityToModelTransformer countyBaseEntityToModelTransformer;
  private final MountainRangeEntityToModelTransformer mountainRangeEntityToModelTransformer;

  public Mountain transform(@NonNull MountainEntity entity) {
    County county = countyBaseEntityToModelTransformer.transform(entity.getCounty());
    MountainRange mountainRange = mountainRangeEntityToModelTransformer.transform(entity.getMountainRange());
    Mountain mountain = Mountain.builder()
      .id(entity.getId())
      .name(entity.getName())
      .irishName(entity.getIrishName())
      .elevation(entity.getElevation())
      .description(entity.getDescription())
      .mountainviewsLink(entity.getMountainViewsLink())
      .county(county)
      .mountainRange(mountainRange)
      .topography(Topography.builder()
        .prominence(entity.getProminence())
        .isolation(entity.getIsolation())
        .bedrockType(entity.getBedrockType())
        .build())
      .location(Location.builder()
        .latitude(entity.getLatitude())
        .longitude(entity.getLongitude())
        .easting(entity.getEasting())
        .northing(entity.getNorthing())
        .gridReference(entity.getGridReference())
        .osiSheetNumber(entity.getOsiSheetNumber())
        .build())
      .unit(Unit.METRIC)
      .build();
    mountain.add(linkTo(methodOn(MountainController.class).findById(entity.getId())).withSelfRel());
    return mountain;
  }
}
