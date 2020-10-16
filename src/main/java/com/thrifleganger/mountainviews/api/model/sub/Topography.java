package com.thrifleganger.mountainviews.api.model.sub;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Topography {
  private Double prominence;
  private Double isolation;
  private String bedrockType;
}
