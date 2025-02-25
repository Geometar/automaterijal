package com.automaterijal.application.domain.dto.tecdoc;

import com.automaterijal.application.tecdoc.AssemblyGroupFacetCount;
import com.automaterijal.application.tecdoc.GenericArticlesRecord;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AssemblyGroupWrapper {
  List<GenericArticlesRecord> genericArticles;
  List<AssemblyGroupFacetCount> assemblyGroupFacetCounts;
}
