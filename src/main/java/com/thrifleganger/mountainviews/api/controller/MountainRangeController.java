package com.thrifleganger.mountainviews.api.controller;

import com.sun.istack.Nullable;
import com.thrifleganger.mountainviews.api.model.MountainRange;
import com.thrifleganger.mountainviews.api.model.MountainRangeExpanded;
import com.thrifleganger.mountainviews.api.service.MountainRangeService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/ranges")
@RequiredArgsConstructor
public class MountainRangeController {

  private final MountainRangeService mountainRangeService;

  @GetMapping
  @ApiOperation(value = "List all mountain ranges in Ireland")
  public ResponseEntity<Page<MountainRange>> getAll(
    @RequestParam(value = "pageNumber", required = false, defaultValue = "0") @Nullable Integer pageNumber,
    @RequestParam(value = "pageSize", required = false, defaultValue = "10") @Nullable Integer pageSize
  ) {
    PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
    return ResponseEntity.ok(mountainRangeService.findAll(pageRequest));
  }

  @GetMapping("/{id}")
  @ApiOperation(value = "Expand specific mountain range by ID")
  public ResponseEntity<MountainRangeExpanded> findById(@PathVariable("id") final UUID id) {
    return ResponseEntity.ok(mountainRangeService.findById(id));
  }
}
