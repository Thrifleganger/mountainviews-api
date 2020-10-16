package com.thrifleganger.mountainviews.api.transformer;

import com.thrifleganger.mountainviews.api.controller.CountyController;
import com.thrifleganger.mountainviews.api.entity.CountyEntity;
import com.thrifleganger.mountainviews.api.model.County;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CountyBaseEntityToModelTransformer {

  public County transform(@NonNull CountyEntity entity) {
    County county = County.builder()
      .id(entity.getId())
      .name(entity.getName())
      .province(entity.getProvince())
      .build();
    county.add(linkTo(methodOn(CountyController.class).findById(entity.getId())).withSelfRel());
    return county;
  }
}
