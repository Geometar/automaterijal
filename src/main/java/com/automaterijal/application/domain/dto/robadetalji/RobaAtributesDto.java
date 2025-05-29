package com.automaterijal.application.domain.dto.robadetalji;

import lombok.Data;

@Data
public class RobaAtributesDto {
  private Long tecDocArticleId;
  private Long robaId;
  private String ppid;
  private Long tecDocPpid;
  private String katbr;
  private String attrValue;
  private String attrUnit;
  private String attrShortName;
  private String attrType;
  private String dokumentId;
  private byte[] dokument;
}
