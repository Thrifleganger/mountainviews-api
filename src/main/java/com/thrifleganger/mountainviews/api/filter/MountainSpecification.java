package com.thrifleganger.mountainviews.api.filter;

import com.thrifleganger.mountainviews.api.entity.MountainEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@RequiredArgsConstructor
public class MountainSpecification implements Specification<MountainEntity> {

  private final SearchCriteria searchCriteria;

  @Override
  public Predicate toPredicate(
    Root<MountainEntity> root,
    CriteriaQuery<?> criteriaQuery,
    CriteriaBuilder criteriaBuilder) {

    switch (searchCriteria.getOperation()) {
      case ">":
        return criteriaBuilder.greaterThanOrEqualTo(
          root.get(searchCriteria.getKey()), searchCriteria.getValue());
      case "<":
        return criteriaBuilder.lessThan(root.get(searchCriteria.getKey()), searchCriteria.getValue());
      case ":":
        if (root.get(searchCriteria.getKey()).getJavaType() == String.class) {
          return criteriaBuilder.like(
            criteriaBuilder.lower(root.get(searchCriteria.getKey())),
            "%" + searchCriteria.getValue().toLowerCase() + "%");
        } else {
          return criteriaBuilder.equal(root.get(searchCriteria.getKey()), searchCriteria.getValue());
        }
    }
    return null;
  }

  public static class Factory implements SpecificationFactory<MountainEntity> {
    @Override
    public Specification<MountainEntity> instance(SearchCriteria searchCriteria) {
      return new MountainSpecification(searchCriteria);
    }
  }
}
