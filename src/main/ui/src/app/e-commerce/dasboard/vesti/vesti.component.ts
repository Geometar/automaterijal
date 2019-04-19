import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { VestiNaslovna, Vest } from '../../model/dto';

@Component({
  selector: 'app-vesti',
  templateUrl: './vesti.component.html',
  styleUrls: ['./vesti.component.scss']
})
export class VestiComponent implements OnInit {

  public vest: Vest;

  constructor(
    private router: Router,
    private route: ActivatedRoute) { }

  ngOnInit() {
    let urlParam;
    this.route.params.subscribe((params: Params) => {
      urlParam = params.id;
    });
    this.vest = this.objediniSveVesti()
      .filter((vest: Vest) => vest.id === urlParam)
      .pop();
  }

  idiNazad() {
    this.router.navigate(['/naslovna']);
  }

  objediniSveVesti() {
    const sveVesti = [];
    sveVesti.push(
      this.shell_u_ponudi(), this.febi_u_ponudi(),
      this.mahle_u_ponudi(), this.ks_u_ponudi());
    return sveVesti;
  }

  shell_u_ponudi(): Vest {
    const shell_u_ponudi = new Vest();
    shell_u_ponudi.id = 'shell-u-ponudi';
    shell_u_ponudi.naslov = '<h1>Sinovac se trazi</h1>';
    shell_u_ponudi.slika = 'assets/slike/novouponudi/velika/shell.png';
    shell_u_ponudi.tekst = '<p>Febi bilstein je  osnovan davne 1844 godine. Danas je jedan od vodećih svetskih proizvođača i dobavljača rezervnih delova za putnička i komercijalna vozila na nezavisnom tržištu rezervnih delova.  Više od 170 godina održava kontinuitet, kvalitet, uslugu, pouzdanost i inovacije. Asortiman cini 30.000 razlicitih rezervnih delova. Osim toga, febi ima svoja predstavništva ili iskusnog partnera u preko 69 zemalja. </p> <p>Od upravljačke, motorne i kočne tehnike, tehnike šasija i učvršćivanja točkova do autoelektrike i pneumatike i programa febi plus – kod firme febi bilstein ćete naći sve za profesionalno servisiranje - putničkih vozila, kamiona, autobusa, prikolica, poluprikolica i malih transportera svih aktuelnih marki i modela.</p> <p class="proba">Febi bilstein stoji za proizvode koji ispunjavaju najviše zahteve kvaliteta izrade i bezbednosti ugradnje. Kvalitetom, brzinom i postavljanjem trendova febi bilstein vam daje odlučujući podsticaj na globalnom tržištu. Zato što kao premium marka ima obavezu da ispuni zahteve svojih kupaca – svakodnevno.</p> <p>AUTOMATERIJAL d.o.o - je zastupnik koncerna Febi Bilstein i Blue Printa za zapadnu Srbiju.</p>';
    return shell_u_ponudi;
  }

  febi_u_ponudi(): Vest {
    const shell_u_ponudi = new Vest();
    shell_u_ponudi.id = 'febi-u-ponudi';
    shell_u_ponudi.naslov = '<h1>Sinovac se trazi</h1>';
    shell_u_ponudi.slika = 'assets/slike/novouponudi/velika/febi.png';
    shell_u_ponudi.tekst = '<p>Febi bilstein je  osnovan davne 1844 godine. Danas je jedan od vodećih svetskih proizvođača i dobavljača rezervnih delova za putnička i komercijalna vozila na nezavisnom tržištu rezervnih delova.  Više od 170 godina održava kontinuitet, kvalitet, uslugu, pouzdanost i inovacije. Asortiman cini 30.000 razlicitih rezervnih delova. Osim toga, febi ima svoja predstavništva ili iskusnog partnera u preko 69 zemalja. </p> <p>Od upravljačke, motorne i kočne tehnike, tehnike šasija i učvršćivanja točkova do autoelektrike i pneumatike i programa febi plus – kod firme febi bilstein ćete naći sve za profesionalno servisiranje - putničkih vozila, kamiona, autobusa, prikolica, poluprikolica i malih transportera svih aktuelnih marki i modela.</p> <p class="proba">Febi bilstein stoji za proizvode koji ispunjavaju najviše zahteve kvaliteta izrade i bezbednosti ugradnje. Kvalitetom, brzinom i postavljanjem trendova febi bilstein vam daje odlučujući podsticaj na globalnom tržištu. Zato što kao premium marka ima obavezu da ispuni zahteve svojih kupaca – svakodnevno.</p> <p>AUTOMATERIJAL d.o.o - je zastupnik koncerna Febi Bilstein i Blue Printa za zapadnu Srbiju.</p>';
    return shell_u_ponudi;
  }

  mahle_u_ponudi(): Vest {
    const shell_u_ponudi = new Vest();
    shell_u_ponudi.id = 'mahle-u-ponudi';
    shell_u_ponudi.naslov = '<h1>Sinovac se trazi</h1>';
    shell_u_ponudi.slika = 'assets/slike/novouponudi/velika/mahle.png';
    shell_u_ponudi.tekst = '<p>Febi bilstein je  osnovan davne 1844 godine. Danas je jedan od vodećih svetskih proizvođača i dobavljača rezervnih delova za putnička i komercijalna vozila na nezavisnom tržištu rezervnih delova.  Više od 170 godina održava kontinuitet, kvalitet, uslugu, pouzdanost i inovacije. Asortiman cini 30.000 razlicitih rezervnih delova. Osim toga, febi ima svoja predstavništva ili iskusnog partnera u preko 69 zemalja. </p> <p>Od upravljačke, motorne i kočne tehnike, tehnike šasija i učvršćivanja točkova do autoelektrike i pneumatike i programa febi plus – kod firme febi bilstein ćete naći sve za profesionalno servisiranje - putničkih vozila, kamiona, autobusa, prikolica, poluprikolica i malih transportera svih aktuelnih marki i modela.</p> <p class="proba">Febi bilstein stoji za proizvode koji ispunjavaju najviše zahteve kvaliteta izrade i bezbednosti ugradnje. Kvalitetom, brzinom i postavljanjem trendova febi bilstein vam daje odlučujući podsticaj na globalnom tržištu. Zato što kao premium marka ima obavezu da ispuni zahteve svojih kupaca – svakodnevno.</p> <p>AUTOMATERIJAL d.o.o - je zastupnik koncerna Febi Bilstein i Blue Printa za zapadnu Srbiju.</p>';
    return shell_u_ponudi;
  }

  ks_u_ponudi(): Vest {
    const shell_u_ponudi = new Vest();
    shell_u_ponudi.id = 'ks-u-ponudi';
    shell_u_ponudi.naslov = '<h1>Sinovac se trazi</h1>';
    shell_u_ponudi.slika = 'assets/slike/novouponudi/velika/ks.png';
    shell_u_ponudi.tekst = '<p>Febi bilstein je  osnovan davne 1844 godine. Danas je jedan od vodećih svetskih proizvođača i dobavljača rezervnih delova za putnička i komercijalna vozila na nezavisnom tržištu rezervnih delova.  Više od 170 godina održava kontinuitet, kvalitet, uslugu, pouzdanost i inovacije. Asortiman cini 30.000 razlicitih rezervnih delova. Osim toga, febi ima svoja predstavništva ili iskusnog partnera u preko 69 zemalja. </p> <p>Od upravljačke, motorne i kočne tehnike, tehnike šasija i učvršćivanja točkova do autoelektrike i pneumatike i programa febi plus – kod firme febi bilstein ćete naći sve za profesionalno servisiranje - putničkih vozila, kamiona, autobusa, prikolica, poluprikolica i malih transportera svih aktuelnih marki i modela.</p> <p class="proba">Febi bilstein stoji za proizvode koji ispunjavaju najviše zahteve kvaliteta izrade i bezbednosti ugradnje. Kvalitetom, brzinom i postavljanjem trendova febi bilstein vam daje odlučujući podsticaj na globalnom tržištu. Zato što kao premium marka ima obavezu da ispuni zahteve svojih kupaca – svakodnevno.</p> <p>AUTOMATERIJAL d.o.o - je zastupnik koncerna Febi Bilstein i Blue Printa za zapadnu Srbiju.</p>';
    return shell_u_ponudi;
  }

}
