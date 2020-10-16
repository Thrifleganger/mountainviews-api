package com.thrifleganger.mountainviews.api.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties("what3words")
public class What3WordsConfig {

  private String apiKey;
  private String url;
}
