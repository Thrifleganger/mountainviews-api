package com.thrifleganger.mountainviews.api.filter;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class SpecificationBuilder<T> {

  private final List<SearchCriteria> params = new ArrayList<>();
  private final SpecificationFactory<T> specificationFactory;

  public SpecificationBuilder<T> with(String key, String operation, String value) {
    params.add(new SearchCriteria(key, operation, value));
    return this;
  }

  public Specification<T> build() {
    if (params.size() == 0) {
      return null;
    }

    List<Specification<T>> specs = params.stream()
      .map(specificationFactory::instance)
      .collect(Collectors.toList());

    Specification<T> result = specs.get(0);

    for (int i = 1; i < params.size(); i++) {
      result = Specification.where(result)
        .and(specs.get(i));
    }
    return result;
  }
}
