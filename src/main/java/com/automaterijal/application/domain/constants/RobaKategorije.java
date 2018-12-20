package com.automaterijal.application.domain.constants;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum RobaKategorije {

    AMORTIZER(Arrays.asList("AMORTIZER")),
    BRAVA(Arrays.asList("BRAVA")),
    BREGASTA(Arrays.asList("BREGASTA", "BREGASTA OSOVINA")),
    BRISAČ(Arrays.asList("BRISAČ")),
    CILINDAR(Arrays.asList("CILINDAR")),
    DIHTUNG(Arrays.asList("DIHTUNG", "DIHTUNG GLAVE","GARN. DIHTUNGA","GARNITURA DIHT","GARNITURA DIHTUNGA")),
    DISK_PLOČICE(Arrays.asList("DISK PLOČICE")),
    DISKOVI(Arrays.asList("DISKOVI")),
    DVOTAKTOL(Arrays.asList("DVOTAKTOL")),
    GREJAČ(Arrays.asList("GREJAČ")),
    GUMICE(Arrays.asList("GUMICA", "GUMICe")),
    HEMIJA(Arrays.asList("HEMIJA")),
    HIDROPODIZAČ(Arrays.asList("HIDROPODIZAČ")),
    HLADNJAK(Arrays.asList("HLADNJAK")),
    ZGLOB(Arrays.asList("HOMOKIN. ZGLOB", "HOMOKINET. ZGLOB", "HOMOKINETIČKI ZGLOB", "ZGLOB")),
    INTERKULER(Arrays.asList("INTERKULER")),
    KABLOVI(Arrays.asList("KABLOVI")),
    KARIKE(Arrays.asList("KARIKE")),
    KARTER(Arrays.asList("KARTER")),
    KLACKALICA(Arrays.asList("KLACKALICA")),
    KLIP(Arrays.asList("KLIP", "KLIPOVI")),
    KOZMETIKA(Arrays.asList("KOZMETIKA")),
    KUGLA(Arrays.asList("KUGLA")),
    LANAC(Arrays.asList("LANAC I LANČANICI")),
    LETVA(Arrays.asList("LETVA VOLANA", "SPONA")),
    LEŽAJEVI(Arrays.asList("LEŽAJEVI RADILICE")),
    MANŽENTA(Arrays.asList("MANŽENTA", "MANŽETNA")),
    PAKNOVI(Arrays.asList("PAKNOVI")),
    PREKIDAČ(Arrays.asList("PREKIDAČ")),
    PROTOKOMER(Arrays.asList("PROTOKOMER")),
    PUMPA(Arrays.asList("PUMPA")),
    RAME(Arrays.asList("RAME", "RAME OSCILUJUĆE")),
    RAZVODNIK(Arrays.asList("RAZVODNIK PALENjA", "RAZVODNIK PALJENJA")),
    REMENICA(Arrays.asList("REMENICA")),
    SEMERING(Arrays.asList("SEMERING")),
    KVAČILO(Arrays.asList("SET KVAČILA", "KVAČILO")),
    SIJALICA(Arrays.asList("SIJALICA")),
    SILEN(Arrays.asList("SILEN BLOK")),
    STABILIZATOR(Arrays.asList("STABILIZATOR")),
    SVEĆICA(Arrays.asList("SVEĆICA", "SVEĆICE")),
    TERMODAVAČ(Arrays.asList("TERMODAVAČ", "TERMOPREKIDAČ")),
    TERMOSTAT(Arrays.asList("TERMOSTAT")),
    VENTIL(Arrays.asList("VENTIL")),
    VENTILATOR(Arrays.asList("VENTILATOR")),
    ZUPČANIK(Arrays.asList("ZUPČANIK"));

    @NonNull
    final List<String> fieldName;
}
