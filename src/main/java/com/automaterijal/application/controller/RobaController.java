package com.automaterijal.application.controller;

import com.automaterijal.application.domain.constants.RobaSortiranjePolja;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.services.RobaService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roba")
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class RobaController {

    @NonNull
    private final
    RobaService robaService;

    @GetMapping
    public ResponseEntity<Page<RobaDto>> pronadjiSvuRobu(
            @RequestParam(required = false) final Integer page,
            @RequestParam(required = false) final Integer pageSize,
            @RequestParam(required = false) final RobaSortiranjePolja sortBy,
            @RequestParam(required = false) final Sort.Direction sortDirection,
            @RequestParam(required = false) final String searchTerm
    ) {
        final Integer internalPage = page == null ? 0 : page;
        final Integer internalPageSize = pageSize == null ? 10 : pageSize;
        final RobaSortiranjePolja internalSortiranjePolja = sortBy == null ? RobaSortiranjePolja.KATBR : sortBy;
        final Sort.Direction internalDirection = sortDirection == null ? Sort.Direction.ASC: sortDirection;
        final String internalSearchTerm = searchTerm == null ? null : searchTerm.trim().toUpperCase();

        final Page<RobaDto> roba = robaService.findAll(internalPage, internalPageSize, internalSortiranjePolja, internalDirection, internalSearchTerm);
        if(roba != null) {
            return new ResponseEntity(roba, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
