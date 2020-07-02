export class Kategorija {
    ikonaId?: string;
    naslov?: string;
    url?: string;
    param?: string;
}

export class Brend {
    urlSlikeLogo?: string;
    urlSlikePozadina?: string;
    url?: string;
    ime?: string;
    opis?: string;
}

export class Konastante {
    kategorije: Kategorija[] = [];
    brendovi: Brend[] = [];
    constructor() {
        const motornaUlja = new Kategorija();
        motornaUlja.ikonaId = 'invert_colors';
        motornaUlja.url = '/kategorije/motorna_ulja';
        motornaUlja.naslov = 'Motorna ulja';
        this.kategorije.push(motornaUlja);
        const aditiv = new Kategorija();

        aditiv.ikonaId = 'eco';
        aditiv.url = '/roba';
        aditiv.param = 'ADITIV';
        aditiv.naslov = 'Aditivi';
        this.kategorije.push(aditiv);

        const komzetika = new Kategorija();
        komzetika.ikonaId = 'eco';
        komzetika.url = '';
        komzetika.naslov = 'Komzetika';
        this.kategorije.push(komzetika);

        const hemija = new Kategorija();
        hemija.ikonaId = 'brightness_1';
        hemija.url = '';
        hemija.naslov = 'Hemija';
        this.kategorije.push(hemija);

        const dvotaktol = new Kategorija();
        dvotaktol.ikonaId = 'invert_colors';
        dvotaktol.url = '';
        dvotaktol.naslov = 'Dvotaktol';
        this.kategorije.push(dvotaktol);


        const motornaUlja1 = new Kategorija();
        motornaUlja1.ikonaId = 'invert_colors';
        motornaUlja1.url = '/kategorije/motorna_ulja';
        motornaUlja1.naslov = 'Motorna ulja';
        this.kategorije.push(motornaUlja1);

        const aditiv1 = new Kategorija();
        aditiv1.ikonaId = 'eco';
        aditiv1.url = '/roba';
        aditiv1.param = 'ADITIV';
        aditiv1.naslov = 'Aditivi';
        this.kategorije.push(aditiv1);

        const komzetika1 = new Kategorija();
        komzetika1.ikonaId = 'eco';
        komzetika1.url = '';
        komzetika1.naslov = 'Komzetika';
        this.kategorije.push(komzetika1);

        const hemija1 = new Kategorija();
        hemija1.ikonaId = 'brightness_1';
        hemija1.url = '';
        hemija1.naslov = 'Hemija';
        this.kategorije.push(hemija1);

        const dvotaktol1 = new Kategorija();
        dvotaktol1.ikonaId = 'invert_colors';
        dvotaktol1.url = '';
        dvotaktol1.naslov = 'Dvotaktol';
        this.kategorije.push(dvotaktol1);

        ///////////////////////
        const slikeLogo = 'assets/slike/brendovi/logo/';
        const slikePozadine = 'assets/slike/brendovi/pagepaper/';
        const txtUrl = 'assets/html/brand/';
        const febi = new Brend();
        febi.ime = 'Febi';
        febi.url = txtUrl + 'febi.txt';
        febi.urlSlikeLogo = slikeLogo + 'febi.png';
        febi.urlSlikePozadina = slikePozadine + 'febi.png';
        this.brendovi.push(febi);

        const shell = new Brend();
        shell.ime = 'Shell';
        shell.url = txtUrl + 'shell.txt';
        shell.urlSlikeLogo = slikeLogo + 'shell.png';
        shell.urlSlikePozadina = slikePozadine + 'shell.png';
        this.brendovi.push(shell);

        const mahle = new Brend();
        mahle.ime = 'Mahle';
        mahle.url = txtUrl + 'mahle.txt';
        mahle.urlSlikeLogo = slikeLogo + 'mahle.png';
        mahle.urlSlikePozadina = slikePozadine + 'mahle.png';
        this.brendovi.push(mahle);

        const vr = new Brend();
        vr.ime = 'Victor Reinz';
        vr.url = txtUrl + 'vr.txt';
        vr.urlSlikeLogo = slikeLogo + 'vik.png';
        vr.urlSlikePozadina = slikePozadine + 'victor-reinz.png';
        this.brendovi.push(vr);

        const pier = new Brend();
        pier.ime = 'Motor Service';
        pier.url = txtUrl + 'pier.txt';
        pier.urlSlikeLogo = slikeLogo + 'pirb.png';
        pier.urlSlikePozadina = slikePozadine + 'pb.png';
        this.brendovi.push(pier);

        const bottari = new Brend();
        bottari.ime = 'Magneti Marreli';
        bottari.url = txtUrl + 'mm.txt';
        bottari.urlSlikeLogo = slikeLogo + 'bottari.png';
        bottari.urlSlikePozadina = slikePozadine + 'magneti-marelli.png';
        this.brendovi.push(bottari);

        const bp = new Brend();
        bp.ime = 'Blue Print';
        bp.url = txtUrl + 'bp.txt';
        bp.urlSlikeLogo = slikeLogo + 'bp.png';
        bp.urlSlikePozadina = slikePozadine + 'blueprint.png';
        this.brendovi.push(bp);

        const wix = new Brend();
        wix.ime = 'Wix';
        wix.url = txtUrl + 'bp.txt';
        wix.urlSlikeLogo = slikeLogo + 'wix.png';
        wix.urlSlikePozadina = slikePozadine + 'wix.png';
        this.brendovi.push(wix);
    }
}
