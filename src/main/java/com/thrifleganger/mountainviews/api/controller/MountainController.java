package com.thrifleganger.mountainviews.api.controller;

import com.sun.istack.Nullable;
import com.thrifleganger.mountainviews.api.entity.MountainEntity;
import com.thrifleganger.mountainviews.api.filter.MountainSpecification;
import com.thrifleganger.mountainviews.api.filter.SpecificationBuilder;
import com.thrifleganger.mountainviews.api.model.Mountain;
import com.thrifleganger.mountainviews.api.service.MountainService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/v1/mountains")
@RequiredArgsConstructor
public class MountainController {

  private final Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
  private final MountainService mountainService;

  @GetMapping
  @ApiOperation(value = "List all mountains", notes = "Provides a JSON list of all Irish mountains in mainland Ireland. " +
    "Use the pageNumber and pageSize parameters to list items in chunks. The pageNumber attribute starts from 0. " +
    "You can use an optional filter parameter to filter results based on any of the fields. The filter criteria should " +
    "be comma separated. Example: filter=elevation>300,name:Croagh")
  public ResponseEntity<Page<Mountain>> getAll(
    @RequestParam(value = "filter", required = false) @Nullable String filterParam,
    @RequestParam(value = "pageNumber", required = false, defaultValue = "0") @Nullable Integer pageNumber,
    @RequestParam(value = "pageSize", required = false, defaultValue = "10") @Nullable Integer pageSize
  ) {
    SpecificationBuilder<MountainEntity> builder = new SpecificationBuilder<>(new MountainSpecification.Factory());
    if (Objects.nonNull(filterParam)) {
      Matcher matcher = pattern.matcher(filterParam.concat(","));
      while (matcher.find()) {
        builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
      }
    }
    PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
    return ResponseEntity.ok(mountainService.findAll(builder.build(), pageRequest));
  }

  @GetMapping("/{id}")
  @ApiOperation(value = "Expand specific mountain by ID")
  public ResponseEntity<Mountain> findById(@PathVariable("id") final UUID id) {
    return ResponseEntity.ok(mountainService.findById(id));
  }
}
