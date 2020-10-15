package com.thrifleganger.mountainviews.api.repository;

import com.thrifleganger.mountainviews.api.entity.County;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CountyRepository extends JpaRepository<County, UUID> {
    List<County> findByName(String name);
}
