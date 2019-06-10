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
    BRISAC(List.of("BRISAČ")),
    CILINDAR(List.of("CILINDAR")),
    DIHTUNG(List.of("DIHTUNG", "DIHTUNG GLAVE","GARN. DIHTUNGA","GARNITURA DIHT","GARNITURA DIHTUNGA")),
    DISK_PLOCICE(List.of("DISK PLOČICE")),
    DISKOVI(List.of("DISKOVI")),
    DVOTAKTOL(List.of("DVOTAKTOL")),
    GREJAC(List.of("GREJAČ")),
    GUMICE(List.of("GUMICA", "GUMICe")),
    HEMIJA(List.of("HEMIJA")),
    HIDROPODIZAC(List.of("HIDROPODIZAČ")),
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
    LEZAJEVI(List.of("LEŽAJEVI RADILICE")),
    MANZENTA(List.of("MANŽENTA", "MANŽETNA")),
    PAKNOVI(List.of("PAKNOVI")),
    PREKIDAC(List.of("PREKIDAČ")),
    PROTOKOMER(List.of("PROTOKOMER")),
    PUMPA(List.of("PUMPA")),
    RAME(List.of("RAME", "RAME OSCILUJUĆE")),
    RAZVODNIK(List.of("RAZVODNIK PALENjA", "RAZVODNIK PALJENJA")),
    REMENICA(List.of("REMENICA")),
    SEMERING(List.of("SEMERING")),
    KVACILO(List.of("SET KVAČILA", "KVAČILO")),
    SIJALICA(List.of("SIJALICA")),
    SILEN(List.of("SILEN BLOK")),
    STABILIZATOR(List.of("STABILIZATOR")),
    SVECICA(List.of("SVEĆICA", "SVEĆICE")),
    TERMODAVAC(List.of("TERMODAVAČ", "TERMOPREKIDAČ")),
    TERMOSTAT(List.of("TERMOSTAT")),
    VENTIL(List.of("VENTIL")),
    VENTILATOR(List.of("VENTILATOR")),
    ZUPCANIK(List.of("ZUPČANIK"));

    @NonNull
    final List<String> fieldName;
}
