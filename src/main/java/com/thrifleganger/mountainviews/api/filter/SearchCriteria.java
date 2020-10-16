package com.thrifleganger.mountainviews.api.filter;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SearchCriteria {
  private String key;
  private String operation;
  private String value;
}
