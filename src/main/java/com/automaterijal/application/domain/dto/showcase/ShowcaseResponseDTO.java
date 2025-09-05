package com.automaterijal.application.domain.dto.showcase;

import com.automaterijal.application.domain.dto.RobaLightDto;
import java.util.List;

public record ShowcaseResponseDTO(
    List<RobaLightDto> prioritetne,
    List<RobaLightDto> maziva,
    List<RobaLightDto> alati,
    List<RobaLightDto> pribor) {}
