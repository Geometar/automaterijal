package com.automaterijal.application.controller;

import com.automaterijal.application.domain.dto.ArticleGroupsDto;
import com.automaterijal.application.services.roba.grupe.ArticleGroupService;
import java.util.List;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/groups")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArticleGroupsController {
  @NonNull ArticleGroupService articleGroupService;

  @GetMapping
  public ResponseEntity<List<ArticleGroupsDto>> findAll() {
    return ResponseEntity.ok(articleGroupService.fetchAllGroupsWithSubgroups());
  }
}
