package com.thrifleganger.mountainviews.api.repository;

import com.thrifleganger.mountainviews.api.entity.CountyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CountyRepository extends JpaRepository<CountyEntity, UUID> {
    List<CountyEntity> findByName(String name);
}
