package com.thrifleganger.mountainviews.api.repository;

import com.thrifleganger.mountainviews.api.entity.Mountain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MountainRepository extends JpaRepository<Mountain, UUID> {
}
