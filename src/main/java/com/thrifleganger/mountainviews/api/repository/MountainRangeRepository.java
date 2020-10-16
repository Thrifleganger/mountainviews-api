package com.thrifleganger.mountainviews.api.repository;

import com.thrifleganger.mountainviews.api.entity.MountainRangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MountainRangeRepository extends JpaRepository<MountainRangeEntity, UUID> {
    List<MountainRangeEntity> findByName(String name);
}
