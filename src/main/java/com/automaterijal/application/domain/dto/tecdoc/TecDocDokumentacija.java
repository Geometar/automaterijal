package com.automaterijal.application.domain.dto.tecdoc;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TecDocDokumentacija {

    String docFileTypeName;
    String docId;
    Long docLinkId;
    String docText;
    Long docTypeId;
    String docTypeName;
    String docUrl;
    byte[] dokument;

}
