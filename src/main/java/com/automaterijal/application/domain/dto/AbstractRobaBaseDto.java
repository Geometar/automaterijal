package com.automaterijal.application.domain.dto;

import java.math.BigDecimal;
import java.util.List;

public abstract class AbstractRobaBaseDto {
  protected Long robaid;
  protected SlikaDto slika;
  protected String grupa;
  protected String katbr;
  protected double stanje;
  protected Double rabat;
  protected BigDecimal cena;
  protected List<RobaTehnickiOpisDto> tehnickiOpis;

  public abstract void setTehnickiOpis(List<RobaTehnickiOpisDto> opisi);

  public abstract List<RobaTehnickiOpisDto> getTehnickiOpis();

  public abstract void setSlika(SlikaDto slika);

  public abstract Long getRobaid();
}
