package com.automaterijal.application.domain.model;

import com.automaterijal.application.utils.GeneralUtil;
import java.util.Locale;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.util.StringUtils;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UniverzalniParametri {

  Integer page;
  Integer pageSize;
  List<String> proizvodjac;
  List<String> mandatoryProid;
  boolean naStanju;
  boolean dostupno;
  String trazenaRec;
  List<String> grupa;
  List<Integer> podgrupeZaPretragu;
  boolean tecdocPretraga;
  boolean paged;
  boolean showcase;
  String filterBy;

  public List<String> resolveProizvodjac() {
    List<String> proizvodjac = this.getProizvodjac();
    if (proizvodjac != null && !proizvodjac.isEmpty()) {
      return proizvodjac;
    }

    List<String> mandatoryProid = this.getMandatoryProid();
    if (mandatoryProid != null && !mandatoryProid.isEmpty()) {
      return mandatoryProid;
    }

    return new ArrayList<>();
  }

  public FilterByType resolveFilterByType() {
    return FilterByType.from(filterBy);
  }

  public boolean shouldApplyManufacturerFilterInQuery() {
    return resolveFilterByType().applyManufacturerFilter();
  }

  public boolean shouldApplyGroupFilterInQuery() {
    return resolveFilterByType().applyGroupFilter();
  }

  public boolean shouldApplySubGroupFilterInQuery() {
    return resolveFilterByType().applySubGroupFilter();
  }

  public UniverzalniParametri copy() {
    UniverzalniParametri copy = new UniverzalniParametri();
    copy.setPage(page);
    copy.setPageSize(pageSize);
    copy.setProizvodjac(proizvodjac != null ? new ArrayList<>(proizvodjac) : null);
    copy.setMandatoryProid(mandatoryProid != null ? new ArrayList<>(mandatoryProid) : null);
    copy.setNaStanju(naStanju);
    copy.setDostupno(dostupno);
    copy.setTrazenaRec(trazenaRec);
    copy.setGrupa(grupa != null ? new ArrayList<>(grupa) : null);
    copy.setPodgrupeZaPretragu(
        podgrupeZaPretragu != null ? new ArrayList<>(podgrupeZaPretragu) : null);
    copy.setTecdocPretraga(tecdocPretraga);
    copy.setPaged(paged);
    copy.setShowcase(showcase);
    copy.setFilterBy(filterBy);
    return copy;
  }

  public UniverzalniParametri normalizedCopy() {
    UniverzalniParametri copy = copy();
    copy.setTrazenaRec(normalizeSearchTerm(copy.getTrazenaRec()));
    copy.setFilterBy(normalizeFilterBy(copy.getFilterBy()));
    return copy;
  }

  private static String normalizeSearchTerm(String raw) {
    if (!StringUtils.hasText(raw)) {
      return null;
    }

    String trimmed = raw.trim();
    if (!StringUtils.hasText(trimmed)) {
      return null;
    }

    return GeneralUtil.cyrillicToLatinic(trimmed).toUpperCase(Locale.ROOT);
  }

  private static String normalizeFilterBy(String raw) {
    return StringUtils.hasText(raw) ? raw.trim().toLowerCase(Locale.ROOT) : null;
  }

  public enum FilterByType {
    CATEGORY("category"),
    SUBCATEGORY("subcategory"),
    MANUFACTURE("manufacture"),
    SEARCH_TERM("searchTerm"),
    NONE(null);

    private final String value;

    FilterByType(String value) {
      this.value = value;
    }

    static FilterByType from(String raw) {
      if (raw == null || raw.isBlank()) {
        return NONE;
      }

      for (FilterByType candidate : values()) {
        if (candidate.value != null && candidate.value.equalsIgnoreCase(raw)) {
          return candidate;
        }
      }

      return NONE;
    }

    public boolean applyManufacturerFilter() {
      return this == NONE || this == MANUFACTURE;
    }

    public boolean applyGroupFilter() {
      return this == NONE || this == CATEGORY;
    }

    public boolean applySubGroupFilter() {
      return this == NONE || this == SUBCATEGORY;
    }
  }
}
