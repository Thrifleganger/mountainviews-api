package com.thrifleganger.mountainviews.api.transformer;

import com.thrifleganger.mountainviews.api.entity.MountainEntity;
import com.thrifleganger.mountainviews.api.model.CountyBase;
import com.thrifleganger.mountainviews.api.model.Mountain;
import com.thrifleganger.mountainviews.api.model.MountainRangeBase;
import com.thrifleganger.mountainviews.api.model.sub.Location;
import com.thrifleganger.mountainviews.api.model.sub.Topography;
import com.thrifleganger.mountainviews.api.model.sub.Unit;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class MountainEntityToModelTransformer {

  public Mountain transform(@NonNull MountainEntity entity) {
    return Mountain.builder()
      .id(entity.getId())
      .name(entity.getName())
      .irishName(entity.getIrishName())
      .description(entity.getDescription())
      .mountainviewsLink(entity.getMountainViewsLink())
      .county(CountyBase.builder()
        .id(entity.getCounty().getId())
        .name(entity.getCounty().getName())
        .province(entity.getCounty().getProvince())
        .build())
      .mountainRange(MountainRangeBase.builder()
        .id(entity.getMountainRange().getId())
        .name(entity.getMountainRange().getName())
        .numberOfPeaks(entity.getMountainRange().getNumberOfMountains())
        .build())
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
  }
}
