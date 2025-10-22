package com.automaterijal.application.domain.model;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UniverzalniParametri {

  Integer page;
  Integer pageSize;
  List<String> proizvodjac;
  List<String> mandatoryProid;
  boolean naStanju;
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
