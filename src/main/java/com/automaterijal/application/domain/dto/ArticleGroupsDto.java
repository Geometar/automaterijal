package com.automaterijal.application.domain.dto;

import java.util.List;

public record ArticleGroupsDto(
    String groupId, String name, List<ArticleSubGroupsDto> articleSubGroups) {}
