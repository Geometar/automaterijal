package com.automaterijal.application.controller;

import com.automaterijal.application.domain.dto.tecdoc.Manufcatures;
import com.automaterijal.application.domain.dto.tecdoc.Model;
import com.automaterijal.application.services.TecDocService;
import com.automaterijal.application.tecdoc.AssemblyGroupFacetCount;
import com.automaterijal.application.tecdoc.LinkageTargetDetails;
import java.util.List;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tecdoc")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class TecDocController {

  @NonNull final TecDocService tecDocService;

  /** Sa dobijenim dokument id-jem, vracamo nazamo byte[] dokument */
  @GetMapping(value = "dokument/{dokumentId}")
  public ResponseEntity<byte[]> vratiRobuPojedinacno(
      @PathVariable("dokumentId") String dokumentId) {
    byte[] documentBytes = tecDocService.vratiDokument(dokumentId, 0);
    return ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_PDF) // Or appropriate content type
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=document.pdf") // Optional
        .body(documentBytes);
  }

  @GetMapping(value = "/manufactures")
  public ResponseEntity<List<Manufcatures>> getManufactures() {
    return ResponseEntity.ok().body(tecDocService.getAllManufactures());
  }

  @GetMapping(value = "/manufactures/{manuId}")
  public ResponseEntity<List<Model>> getModels(
      @PathVariable("manuId") Integer manuId,
      @RequestParam(value = "type", required = false, defaultValue = "PO") String type) {
    return ResponseEntity.ok().body(tecDocService.getModelsForModeId(manuId, type));
  }

  @GetMapping(value = "/manufactures/{manuId}/{modelId}")
  public ResponseEntity<List<LinkageTargetDetails>> getModels(
      @PathVariable("manuId") Integer manuId,
      @PathVariable("modelId") Integer modelId,
      @RequestParam(value = "type", required = false, defaultValue = "PO") String type) {
    return ResponseEntity.ok().body(tecDocService.getModelSubTypes(manuId, modelId, type));
  }

  @GetMapping(value = "/linkageTargets")
  public ResponseEntity<List<LinkageTargetDetails>> getLinkageTargets(
      @RequestParam(value = "tecdocTargetType") String type,
      @RequestParam(value = "tecdocTargetId") Integer id) {
    return ResponseEntity.ok().body(tecDocService.getLinkageTargetDetails(id, type));
  }

  @GetMapping(value = "/assemblygroup/{linkedTargetId}/{type}")
  public ResponseEntity<List<AssemblyGroupFacetCount>> getAssemblyGroupsForVehicle(
      @PathVariable("linkedTargetId") Integer linkedTargetId, @PathVariable("type") String type) {
    return ResponseEntity.ok()
        .body(tecDocService.getAssemblyGroupsForVehicle(type, linkedTargetId));
  }
}
