import { Page } from './page';

export class ValueHelp {
   id?: number;
   naziv?: string;
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
    webStatus?: number;
    loginCount?: any;
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
    iznosNarucen?: number;
    iznosPotvrdjen?: number;
    detalji?: FakturaDetalji[];
}

export class FakturaPage extends Page {
    content: Fakutra[] = null;
}

export class FakturaDetalji {
    robaId?: number;
    slikaId?: number;
    naziv?: string;
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

export class Magacin {
    public robaDto: RobaPage;
    public podgrupe: string[];
    public proizvodjaci: Proizvodjac[];
}

export class Roba {
    public robaid: number;
    public slika: string;
    public katbr: string;
    public katbrpro: string;
    public naziv: string;
    public stanje: number;
    public cena: number;
    public rabat: number;
    public kolicina: number;
    public proizvodjac: Proizvodjac;
    public tehnickiOpis?: RobaTehnickiOpis[];
    public tdBrojevi?: Map<string, RobaBrojevi[]>;
    public aplikacije?: Map<string, RobaAplikacija[]>;
}

export class RobaPage extends Page {
    content: Roba[] = null;
}
export class RobaTehnickiOpis {
    oznaka?: number;
    vrednost?: number;
    jedinica?: number;
}
export class RobaBrojevi {
    fabrBroj?: string;
    proizvodjac?: string;
}
export class RobaAplikacija {
    proizvodjacNaziv?: string;
    modelNaziv?: string;
    tipVozila?: string;
    proizOd?: string;
    proizDo?: string;
    hp?: string;
    kw?: string;
    ccm?: string;
}
