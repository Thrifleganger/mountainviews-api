package com.thrifleganger.mountainviews.api.service;

import com.thrifleganger.mountainviews.api.entity.Mountain;
import com.thrifleganger.mountainviews.api.repository.MountainRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MountainService {

    private final MountainRepository mountainRepository;

    public List<Mountain> findAll() {
        return mountainRepository.findAll();
    }

    public Mountain findById(@NonNull UUID id) {
        return mountainRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
