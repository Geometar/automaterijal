package com.automaterijal.application.services.tecdoc;

import com.automaterijal.application.client.TecDocClient;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class TecDocDocumentService {

  @NonNull TecDocClient tecDocClient;

  public byte[] getDocument(String dokumentId, Integer tipSlike) {
    return tecDocClient.vratiDokument(dokumentId, tipSlike);
  }
}
