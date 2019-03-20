package com.automaterijal.application.domain.constants;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@RequiredArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum RobaKategorije {

    AMORTIZER(List.of("AMORTIZER")),
    BRAVA(List.of("BRAVA")),
    BREGASTA(List.of("BREGASTA", "BREGASTA OSOVINA")),
    BRISAČ(List.of("BRISAČ")),
    CILINDAR(List.of("CILINDAR")),
    DIHTUNG(List.of("DIHTUNG", "DIHTUNG GLAVE","GARN. DIHTUNGA","GARNITURA DIHT","GARNITURA DIHTUNGA")),
    DISK_PLOČICE(List.of("DISK PLOČICE")),
    DISKOVI(List.of("DISKOVI")),
    DVOTAKTOL(List.of("DVOTAKTOL")),
    GREJAČ(List.of("GREJAČ")),
    GUMICE(List.of("GUMICA", "GUMICe")),
    HEMIJA(List.of("HEMIJA")),
    HIDROPODIZAČ(List.of("HIDROPODIZAČ")),
    HLADNJAK(List.of("HLADNJAK")),
    ZGLOB(List.of("HOMOKIN. ZGLOB", "HOMOKINET. ZGLOB", "HOMOKINETIČKI ZGLOB", "ZGLOB")),
    INTERKULER(List.of("INTERKULER")),
    KABLOVI(List.of("KABLOVI")),
    KARIKE(List.of("KARIKE")),
    KARTER(List.of("KARTER")),
    KLACKALICA(List.of("KLACKALICA")),
    KLIP(List.of("KLIP", "KLIPOVI")),
    KOZMETIKA(List.of("KOZMETIKA")),
    KUGLA(List.of("KUGLA")),
    LANAC(List.of("LANAC I LANČANICI")),
    LETVA(List.of("LETVA VOLANA", "SPONA")),
    LEŽAJEVI(List.of("LEŽAJEVI RADILICE")),
    MANŽENTA(List.of("MANŽENTA", "MANŽETNA")),
    PAKNOVI(List.of("PAKNOVI")),
    PREKIDAČ(List.of("PREKIDAČ")),
    PROTOKOMER(List.of("PROTOKOMER")),
    PUMPA(List.of("PUMPA")),
    RAME(List.of("RAME", "RAME OSCILUJUĆE")),
    RAZVODNIK(List.of("RAZVODNIK PALENjA", "RAZVODNIK PALJENJA")),
    REMENICA(List.of("REMENICA")),
    SEMERING(List.of("SEMERING")),
    KVAČILO(List.of("SET KVAČILA", "KVAČILO")),
    SIJALICA(List.of("SIJALICA")),
    SILEN(List.of("SILEN BLOK")),
    STABILIZATOR(List.of("STABILIZATOR")),
    SVEĆICA(List.of("SVEĆICA", "SVEĆICE")),
    TERMODAVAČ(List.of("TERMODAVAČ", "TERMOPREKIDAČ")),
    TERMOSTAT(List.of("TERMOSTAT")),
    VENTIL(List.of("VENTIL")),
    VENTILATOR(List.of("VENTILATOR")),
    ZUPČANIK(List.of("ZUPČANIK"));

    @NonNull
    final List<String> fieldName;
}
