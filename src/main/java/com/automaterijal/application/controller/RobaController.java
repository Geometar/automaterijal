package com.automaterijal.application.controller;

import com.automaterijal.application.domain.entity.Roba;
import com.automaterijal.application.services.RobaService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/roba")
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Slf4j
public class RobaController {

    @NonNull
    private
    RobaService robaService;

    @GetMapping
    public ResponseEntity<List<Roba>> pronadjiSvuRobu(
            @RequestParam(required = false) final Integer page,
            @RequestParam(required = false) final Integer pageSize
    ) {
        final Integer internalPage = page == null ? 0 : page;
        final Integer internalPageSize = pageSize == null ? 5 : page;

        final Page<Roba> roba = robaService.findAll(internalPage, internalPageSize);
        if(roba != null) {
            return new ResponseEntity(roba, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
