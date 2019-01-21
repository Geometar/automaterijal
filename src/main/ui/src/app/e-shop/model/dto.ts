import { Page } from './page';

export class ValueHelp {
   id?: number;
   naziv?: string;
}

export class Roba {
    public robaid: number;
    public katbr: string;
    public katbrpro: string;
    public naziv: string;
    public proizvodjac: Proizvodjac;
    public grupa: string;
    public podGrupa: string;
    public stanje: number;
    public cena: number;
    public rabat: number;
    public kolicina: number;
}

export class RobaPage extends Page {
    content: Roba[] = null;
}

export class Partner {
    ppid?: number;
    naziv?: string;
    email?: string;
    adresa?: string;
    webKorisnik?: string;
    noviPassword?: string;
    stariPassword?: string;
    stanje?: number;
    stanjeporoku?: number;
}

export class Fakutra {
    id?: number;
    orderId?: number;
    vremePorucivanja?: string;
    status?: ValueHelp;
    nacinPlacanja?: ValueHelp;
    nacinPrevoza?: ValueHelp;
    adresa?: ValueHelp;
    napomena?: string;
    brojStavki?: number;
    iznos?: number;
    detalji?: FakturaDetalji[];
}

export class FakturaPage extends Page {
    content: Fakutra[] = null;
}

export class FakturaDetalji {
    robaId?: number;
    kataloskiBroj?: string;
    proizvodjac?: Proizvodjac;
    kolicina?: number;
    potvrdjenaKolicina?: number;
    cena?: number;
    status?: ValueHelp;
    rabat?: number;
    vremePorucivanja?: string;
}

export class Proizvodjac {
    public proid: string;
    public naziv: string;
}

export declare class Credentials {
    username?: string;
    password?: boolean;
}

export class Registracija {
    // Pravno Lice
    nazivFirme?: string;
    pib?: string;
    // Fizicko Lice
    imeIPrezime?: string;
    // zajednicki sadrzilac
    grad?: string;
    adresa?: string;
    email?: string;
    kontaktTelefon?: string;
    daLiJePravnoLice?: boolean;
}

export class ResetSifre {
    email?: string;
}

export class PromenaSifre {
    ppid?: number;
    staraSifra?: string;
    sifra?: string;
    ponovljenjaSifra?: string;
}
