package com.thrifleganger.mountainviews.api.controller;

import com.sun.istack.Nullable;
import com.thrifleganger.mountainviews.api.model.County;
import com.thrifleganger.mountainviews.api.model.CountyExpanded;
import com.thrifleganger.mountainviews.api.service.CountyService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/counties")
@RequiredArgsConstructor
public class CountyController {

  private final CountyService countyService;

  @GetMapping
  @ApiOperation(value = "List all counties in Ireland")
  public ResponseEntity<Page<County>> getAll(
    @RequestParam(value = "pageNumber", required = false, defaultValue = "0") @Nullable Integer pageNumber,
    @RequestParam(value = "pageSize", required = false, defaultValue = "10") @Nullable Integer pageSize
  ) {
    PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
    return ResponseEntity.ok(countyService.findAll(pageRequest));
  }

  @GetMapping("/{id}")
  @ApiOperation(value = "Expand specific county by ID")
  public ResponseEntity<CountyExpanded> findById(@PathVariable("id") final UUID id) {
    return ResponseEntity.ok(countyService.findById(id));
  }
}
