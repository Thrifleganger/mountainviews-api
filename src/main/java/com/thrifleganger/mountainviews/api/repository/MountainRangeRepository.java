package com.thrifleganger.mountainviews.api.repository;

import com.thrifleganger.mountainviews.api.entity.MountainRange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MountainRangeRepository extends JpaRepository<MountainRange, UUID> {
    List<MountainRange> findByName(String name);
}
