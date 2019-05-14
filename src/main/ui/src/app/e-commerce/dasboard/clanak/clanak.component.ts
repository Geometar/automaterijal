import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { VestiNaslovna, Vest } from '../../model/dto';

@Component({
  selector: 'app-clanak',
  templateUrl: './clanak.component.html',
  styleUrls: ['./clanak.component.scss']
})
export class ClanakComponent implements OnInit {

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
    shell_u_ponudi.naslov = '<h1>Uz novu <b>GTL</b> tehnologiju budućnost je počela</h1>';
    shell_u_ponudi.slika = 'assets/slike/novouponudi/velika/shell.png';
    shell_u_ponudi.tekst = '<p>Shell je multinacionalna angloholandska naftna kompanija osnovana osnovana u Ujedinjenom Kraljevstvu sa sedištem u Holandiji. Kompanija je vertikalno integrisana i ima aktivnosti gotovo u svim područijima industrije nafte i gasa. Kao vodeća kompanija u proizvodnji ulja I maziva prisutan je u preko 100 zemalja. U svom portfoliu ima preko 2000 proizvoda raznih namena kako bi odgovorio svim zahtevima koje tržište diktira. Shell je takođe izbor mnogih proizvođača vozila, mašina, industrijskih postrojenja I mnogih dugih proizvođača kao prvo punjenje u svojim proizvodima. Shell je trenutno jedina energentska kompanija na svetu koja bazna ulja dobija iz gasa (GTL tehnologija). Postorjenje za preradu se nalazi u Kataru i jedino je tog tipa. Prvo postrojenje se nalazilo u Maleziji I napravljeno je pre 40 godina I sluzilo je za razvoj tehnologije. Razvitkom fabrika je premeštena u Katar I sada punim kapacitetima proizvodi potrebne količine baznog ulja za potrebe svetskog tržišta. </p> <p>Šel je takođe I po tržišnoj kapitalizaciji jedno od vodećih preuzeća u svetu. Šel je u  2013 godini bio vodeće preduzeće na Fortune global 500-listi najvećih preduzeća na svetu.</p>';
    return shell_u_ponudi;
  }

  febi_u_ponudi(): Vest {
    const shell_u_ponudi = new Vest();
    shell_u_ponudi.id = 'febi-u-ponudi';
    shell_u_ponudi.naslov = '<h1>Kompletno rešenje za vaše vozilo</h1>';
    shell_u_ponudi.slika = 'assets/slike/novouponudi/velika/febi.png';
    shell_u_ponudi.tekst = '<p>Febi bilstein je  osnovan davne 1844 godine. Danas je jedan od vodećih svetskih proizvođača i dobavljača rezervnih delova za putnička i komercijalna vozila na nezavisnom tržištu rezervnih delova.  Više od 170 godina održava kontinuitet, kvalitet, uslugu, pouzdanost i inovacije. Asortiman cini 30.000 razlicitih rezervnih delova. Osim toga, febi ima svoja predstavništva ili iskusnog partnera u preko 69 zemalja. </p> <p>Od upravljačke, motorne i kočne tehnike, tehnike šasija i učvršćivanja točkova do autoelektrike i pneumatike i programa febi plus – kod firme febi bilstein ćete naći sve za profesionalno servisiranje - putničkih vozila, kamiona, autobusa, prikolica, poluprikolica i malih transportera svih aktuelnih marki i modela.</p> <p class="proba">Febi bilstein stoji za proizvode koji ispunjavaju najviše zahteve kvaliteta izrade i bezbednosti ugradnje. Kvalitetom, brzinom i postavljanjem trendova febi bilstein vam daje odlučujući podsticaj na globalnom tržištu. Zato što kao premium marka ima obavezu da ispuni zahteve svojih kupaca – svakodnevno.</p> <p>AUTOMATERIJAL d.o.o - je zastupnik koncerna Febi Bilstein i Blue Printa za zapadnu Srbiju.</p>';
    return shell_u_ponudi;
  }

  mahle_u_ponudi(): Vest {
    const mahle_u_ponudi = new Vest();
    mahle_u_ponudi.id = 'mahle-u-ponudi';
    mahle_u_ponudi.naslov = '<h1>U korak sa vremenom</h1>';
    mahle_u_ponudi.slika = 'assets/slike/novouponudi/velika/mahle.png';
    mahle_u_ponudi.tekst = '<p>Mahle je vodeći međunarodni partner za razvoj I dobavljač za automobilsku industriju, kao I pionir I pokretač tehnologije za budućnost.</p> <p>Zasnovan na velikoj složenosti sistema koja se sastoji od motora I komponenata motora, filtriranja I upravljanja toplotnom energijom, portfolio proizvoda grupe se bavi svim ključnim pitanjima vezanim za tehnologiju pogonskog sistema i klima uređaja.</p> <p>Mahle proizvodi se ugrađuju u najmanje svako drugo vozilo širom sveta. Decenijama Mahle komponente I sistemi su takođe korišćeni na svetskim trkalištima I izvan puta-u stacionarnim aplikacijama, za mobilnu mašineriju, železničku transport, kao I pomorske aplikacije.</p> <p>Ono po čemu je Mahle preopoznatljiv širom sveta je svakako pre svega motorna grupa. Ogroman deo svetskih proizvođača vozila, kako  putničkih tako I teretnih upravo ugrađuju u svoje motore komponente dizajnirane u napravljene u Mahle fabrikama. Takođe, kupovinom svetskog Brenda Knecht, Mahle ulazi kao premijum proizvođač filtera na tržište, nudeći svoje proizvode u aftermarketu istog kvaliteta kao I oni koji su prva ugradnja ovog proizvođača.</p> <p>Kupovinom nekoliko velikih proizođača komponenti za vozila Mahle je svoj portfolio proširio I na uređaje vezane za klimatizaciju vozila, termomenadžment, turbopunjače, alternatore, alnasere I mnoge druge sastavne delove vozila. Ono po čemu je mahle prepoznatljiv je motorna grupa.</p>';
    return mahle_u_ponudi;
  }

  ks_u_ponudi(): Vest {
    const shell_u_ponudi = new Vest();
    shell_u_ponudi.id = 'ks-u-ponudi';
    shell_u_ponudi.naslov = '<h1>Godine poverenja su preporuka</h1>';
    shell_u_ponudi.slika = 'assets/slike/novouponudi/velika/ks.png';
    shell_u_ponudi.tekst = '<p>U svojoj ulozi dobavljača prvog reda, Pierburg je tradicionalno bio jedan od najbližih partnera automobilskoj industriji, od samog početka uspešnog unapređenja razvoja automobila.Pierburg je osnovan 1909. godine kao trgovac čelikom u Berlinu; 1928. godine, Pierburg je počeo s proizvodnjom karburatora i vrlo brzo je stsao u glavnog  dobavljača za sve nemačke proizvođače automobila i mnoge međunarodne proizvođače motornih vozila i proizvođače motora.Godine 1986. Pierburg je preuzeo Rheinmetall Group i 1998. se spojio sa Kolbenschmidt-om da bi formirao Kolbenschmidt Pierburg AG.U okviru Rheinmetall Automotive, Pierburg je specijalista za kontrolu emisije, dovod vazduha, prigušne ventile i solenoidne ventile.Decenije iskustva u kombinaciji sa sveobuhvatnim, inovativnim i globalno priznatim mogućnostima u svakom aspektu motora su faktori koji su doveli Pierburg u svoju misiju da stalno razvija i proizvodi komponente, module i sisteme za budućnost.U razvoju novih generacija motora dobijaju na značaju takvi faktori kao što su smanjena potrošnja goriva, niže emisije štetnih gasova  i poboljšane performanse, udobnost i sigurnost.U te svrhe, Pierburg nudi visoko tehnološka rešenja: električne pumpe za hlađenje na zahtev, sisteme za recirkulaciju izduvnih gasova  sa ​​istosmernim motorom, ventile za odvod vazduha, te različite verzije pogonskih modula. Svi ovi razvoji pomažu da se stvori ekonomski i ekološki uravnotežen automobil.</p> <p>Divizija KS Kolbenschmidt razvija, proizvodi i prodaje klipove za benzinske i dizel motore za automobile i komercijalna vozila i jedan je od najistaknutijih igrača u svom segmentu. Ostali proizvodi uključuju klipove za dvotaktne i kompresorske motore kao i velike klipove za stacionarne, brodske i lokomotivne motore.Unapređenje gustine snage, kao i postizanje daljnjeg smanjenja potrošnje goriva i emisija, već godinama predstavljaju faktore koji utiču na razvoj novih tipova klipova kod KS Kolbenschmidt.</p>';
    return shell_u_ponudi;
  }

}
