package com.thrifleganger.mountainviews.api.repository;

import com.thrifleganger.mountainviews.api.entity.MountainEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MountainRepository extends JpaRepository<MountainEntity, UUID> {
}
