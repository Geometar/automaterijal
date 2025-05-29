package com.automaterijal.application.domain.entity.tecdoc;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TecDocAtributi {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  Integer id;

  Long tecDocArticleId;
  Long robaId;
  String ppid;
  Long tecDocPpid;
  String katbr;
  String attrValue;
  String attrUnit;
  String attrShortName;

  //  Attribute types:
  //  A: Alphanumeric
  //  D: Date
  //  K: Key
  //  N: Numeric
  //  V: Without value
  String attrType;
  String dokumentId;
  byte[] dokument;
}
