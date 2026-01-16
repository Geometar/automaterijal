package com.automaterijal.application.services.roba.grupe;

import com.automaterijal.application.domain.dto.ArticleGroupsDto;
import com.automaterijal.application.domain.dto.ArticleSubGroupsDto;
import com.automaterijal.application.domain.entity.Grupa;
import com.automaterijal.application.domain.entity.PodGrupa;
import com.automaterijal.application.domain.repository.GrupaRepository;
import com.automaterijal.application.domain.repository.PodGrupaRepository;
import java.util.Map;
import java.util.Objects;
import java.util.Arrays;
import java.util.List;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class ArticleGroupService {

  @NonNull final GrupaRepository grupaRepository;
  @NonNull final PodGrupaRepository podGrupaRepository;

  public static final List<String> FORBIDDEN_CATEGORIES =
      Arrays.asList("PN", "TG", "6000", "LUCO", "ANULL");

  public List<ArticleGroupsDto> fetchAllGroupsWithSubgroups() {
    List<Grupa> allGroups = grupaRepository.findAllByOrderByNaziv();
    List<PodGrupa> allSubGroups = podGrupaRepository.findAll();

    return allGroups.stream()
        .filter(group -> !FORBIDDEN_CATEGORIES.contains(group.getGrupaid()))
        .map(
            group -> {
              List<ArticleSubGroupsDto> matchingSubGroups =
                  filterForSubgroups(allSubGroups, group.getGrupaid());
              return new ArticleGroupsDto(group.getGrupaid(), group.getNaziv(), matchingSubGroups);
            })
        .toList();
  }

  private List<ArticleSubGroupsDto> filterForSubgroups(
      List<PodGrupa> allSubGroups, String groupId) {
    return allSubGroups.stream()
        .filter(subGroups -> subGroups.getGrupaId().equals(groupId))
        .map(this::mapToArticleSubgroups)
        .toList();
  }

  private ArticleSubGroupsDto mapToArticleSubgroups(PodGrupa subGroup) {
    return new ArticleSubGroupsDto(
        subGroup.getPodGrupaId(), subGroup.getGrupaId(), subGroup.getNaziv());
  }

  public String getGroupName(String groupId) {
    return grupaRepository.findById(groupId).map(Grupa::getNaziv).orElse("");
  }

  public List<Grupa> findAll() {
    return grupaRepository.findAll();
  }

  public Map<String, String> groupNamesById() {
    return grupaRepository.findAll().stream()
        .filter(Objects::nonNull)
        .filter(g -> g.getGrupaid() != null)
        .collect(
            java.util.stream.Collectors.toMap(
                Grupa::getGrupaid, g -> Objects.requireNonNullElse(g.getNaziv(), ""), (a, b) -> a));
  }
}
