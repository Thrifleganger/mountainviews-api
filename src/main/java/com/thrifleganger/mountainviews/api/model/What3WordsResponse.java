package com.thrifleganger.mountainviews.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class What3WordsResponse {
  private String country;
  private Square square;
  private String nearestPlace;
  private Coordinates coordinates;
  private String language;
  private String map;
  private String words;

  @Getter
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Square {
    private Coordinates southwest;
    private Coordinates northeast;
  }

  @Getter
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Coordinates {
    private String lat;
    private String lng;
  }
}