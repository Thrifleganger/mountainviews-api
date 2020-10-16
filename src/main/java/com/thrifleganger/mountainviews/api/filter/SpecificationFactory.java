package com.thrifleganger.mountainviews.api.filter;

import org.springframework.data.jpa.domain.Specification;

public interface SpecificationFactory<T> {
  Specification<T> instance(SearchCriteria searchCriteria);
}
