package com.automaterijal.application.domain.dto.helpper;

import com.automaterijal.application.domain.dto.ProizvodjacDTO;
import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.dto.RobaTehnickiOpisDto;
import com.automaterijal.application.domain.dto.SlikaDto;
import java.math.BigDecimal;
import java.util.List;

public class RobaLightDtoBuilderHelper {

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    private final RobaLightDto dto = new RobaLightDto();

    public Builder robaid(Long id) {
      dto.setRobaid(id);
      return this;
    }

    public Builder katbr(String katbr) {
      dto.setKatbr(katbr);
      return this;
    }

    public Builder katbrpro(String katbrpro) {
      dto.setKatbrpro(katbrpro);
      return this;
    }

    public Builder naziv(String naziv) {
      dto.setNaziv(naziv);
      return this;
    }

    public Builder stanje(double stanje) {
      dto.setStanje(stanje);
      return this;
    }

    public Builder grupa(String grupa) {
      dto.setGrupa(grupa);
      return this;
    }

    public Builder podGrupa(int podGrupa) {
      dto.setPodGrupa(podGrupa);
      return this;
    }

    public Builder proizvodjac(ProizvodjacDTO dtoProizvodjac) {
      dto.setProizvodjac(dtoProizvodjac);
      return this;
    }

    public Builder slika(SlikaDto slika) {
      dto.setSlika(slika);
      return this;
    }

    public Builder cena(BigDecimal cena) {
      dto.setCena(cena);
      return this;
    }

    public Builder rabat(Double rabat) {
      dto.setRabat(rabat);
      return this;
    }

    public Builder tehnickiOpis(List<RobaTehnickiOpisDto> opisi) {
      dto.setTehnickiOpis(opisi);
      return this;
    }

    public RobaLightDto build() {
      return dto;
    }
  }
}
