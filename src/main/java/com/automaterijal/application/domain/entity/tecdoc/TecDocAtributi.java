package com.automaterijal.application.domain.entity.tecdoc;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import jakarta.persistence.*;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TecDocAtributi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Integer id;
    Integer tecDocArticleId;
    Long robaId;
    String ppid;
    Integer tecDocPpid;
    String katbr;
    String attrValue;
    String attrUnit;
    String attrShortName;
    String attrType;
    String dokumentId;
    byte[] dokument;
}
