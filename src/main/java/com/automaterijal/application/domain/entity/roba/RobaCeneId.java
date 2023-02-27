package com.automaterijal.application.domain.entity.roba;

import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
public class RobaCeneId implements Serializable {

  Long magacinid;
  Long robaid;
}

