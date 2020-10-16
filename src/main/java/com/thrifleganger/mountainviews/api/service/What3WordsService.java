package com.thrifleganger.mountainviews.api.service;

import com.thrifleganger.mountainviews.api.config.What3WordsConfig;
import com.thrifleganger.mountainviews.api.model.What3WordsResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class What3WordsService {

  private final RestTemplate restTemplate;
  private final What3WordsConfig config;

  public What3WordsResponse convert(@NonNull String latitude, @NonNull String longitude) {
    String url = String.format(
      config.getUrl(),
      String.format("%s,%s", latitude, longitude),
      config.getApiKey()
    );
    ResponseEntity<What3WordsResponse> response = restTemplate.getForEntity(url, What3WordsResponse.class);
    return response.getBody();
  }
}
