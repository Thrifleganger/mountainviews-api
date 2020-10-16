package com.thrifleganger.mountainviews.api.model;

import com.thrifleganger.mountainviews.api.model.sub.MountainSummary;
import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
public class MountainRangeExpanded extends RepresentationModel<MountainRangeExpanded> {
  private UUID id;
  private String name;
  private Integer numberOfPeaks;
  private List<MountainSummary> mountains;
}
