import { Proizvodjač } from './dto';

export class Korpa {
    public roba: RobaKorpa[] = [];
    public ukupno: number;
    public nacinPlacanja: number;
    public nacinIsporuke: number;
    public napomena: string;
}

export class RobaKorpa {

    public robaid: number;
    public katbr: string;
    public katbrpro: string;
    public naziv: string;
    public proizvodjac: Proizvodjač;
    public kolicina: number;
    public rabat: number;
    public cenaKom: number;
    public stanje: number;
    public cenaUkupno: number;

    constructor(robaid: number, katbr: string, katbrpro: string, naziv: string, proizvodjac: Proizvodjač,
         kolicina: number, rabat: number, cena: number, stanje: number) {
        this.robaid = robaid;
        this.katbr = katbr;
        this.katbrpro = katbrpro;
        this.naziv = naziv;
        this.proizvodjac = proizvodjac;
        this.kolicina = kolicina;
        this.rabat = rabat;
        this.cenaKom = cena;
        this.cenaUkupno = cena * kolicina;
        this.stanje = stanje;
    }
}

export class RobaPromena {
    katbr: string = null;
    opis: string = null;
    rapolozivaKolicina: number = null;
    trazenaKolicina: number = null;
}
