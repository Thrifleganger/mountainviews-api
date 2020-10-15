package com.thrifleganger.mountainviews.api.controller;

import com.thrifleganger.mountainviews.api.entity.Mountain;
import com.thrifleganger.mountainviews.api.service.MountainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/mountains")
@RequiredArgsConstructor
public class MountainController {

  private final MountainService mountainService;

  @GetMapping
  public ResponseEntity<List<Mountain>> getAll() {
    return ResponseEntity.ok(mountainService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Mountain> findById(@PathVariable("id") final UUID id) {
    return ResponseEntity.ok(mountainService.findById(id));
  }
}