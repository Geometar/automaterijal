import { Component, OnInit, HostListener } from '@angular/core';
import { Brend } from '../model/dto';
import { MatDialog } from '@angular/material';
import { BrendoviModalComponent } from 'src/app/shared/modal/brendovi-modal/brendovi-modal.component';
import { e } from '@angular/core/src/render3';

@Component({
  selector: 'app-o-nama',
  templateUrl: './o-nama.component.html',
  styleUrls: ['./o-nama.component.scss']
})
export class ONamaComponent implements OnInit {
  innerWidth;
  public mySlideBrands = this.vratiSveBrendove();

  public mySlideLargeOptions = {
    items: 7, margin: 20,
    dots: true, nav: false, autoplay: true,
    autoplayTimeout: 2500, rewind: true
  };
  
  public mySlideSmallOptions = {
    items: 3, margin: 5,
    dots: true, nav: false, autoplay: true,
    autoplayTimeout: 2500, rewind: true
  };

  public isLargeDiv = window.innerWidth > 750;

  constructor(public dialog: MatDialog) { }

  ngOnInit() {
    this.innerWidth = window.innerWidth;
    this.changeSlideConfiguration();
  }

  changeSlideConfiguration() {
    if (this.innerWidth < 750) {
      this.isLargeDiv = false;
    } else {
      this.isLargeDiv = true;
    }
  }

  otvoriDialog(brend: Brend) {
    this.dialog.open(BrendoviModalComponent, {
      width: '700px',
      data: brend
    });
  }

  vratiSveBrendove() {
    const nizOdBrendova = [];
    const febi = this.febi();
    const shell = this.shell();
    const mahle = this.mahle();
    const kolbenschmidt = this.kolbenschmidt();
    const pierburg = this.pierburg();
    const victorReinz = this.victorReinz();
    const bluePrint = this.bluePrint();
    const mm = this.mm();
    nizOdBrendova.push(febi, shell, mahle, victorReinz, kolbenschmidt, pierburg, mm, bluePrint);
    return nizOdBrendova;
  }

  febi() {
    const febi = new Brend();
    febi.ime = 'Febi';
    febi.urlSlikeLogo = 'assets/slike/brendovi/logo/febi.png';
    febi.urlSlikePozadina = 'assets/slike/brendovi/pagepaper/febi.png';
    febi.opis = '<p>Febi bilstein je  osnovan davne 1844 godine. Danas je jedan od vodećih svetskih proizvođača i dobavljača rezervnih delova za putnička i komercijalna vozila na nezavisnom tržištu rezervnih delova.  Više od 170 godina održava kontinuitet, kvalitet, uslugu, pouzdanost i inovacije. Asortiman cini 30.000 razlicitih rezervnih delova. Osim toga, febi ima svoja predstavništva ili iskusnog partnera u preko 69 zemalja. </p> <p>Od upravljačke, motorne i kočne tehnike, tehnike šasija i učvršćivanja točkova do autoelektrike i pneumatike i programa febi plus – kod firme febi bilstein ćete naći sve za profesionalno servisiranje - putničkih vozila, kamiona, autobusa, prikolica, poluprikolica i malih transportera svih aktuelnih marki i modela.</p> <p class="proba">Febi bilstein stoji za proizvode koji ispunjavaju najviše zahteve kvaliteta izrade i bezbednosti ugradnje. Kvalitetom, brzinom i postavljanjem trendova febi bilstein vam daje odlučujući podsticaj na globalnom tržištu. Zato što kao premium marka ima obavezu da ispuni zahteve svojih kupaca – svakodnevno.</p> <p>AUTOMATERIJAL d.o.o - je zastupnik koncerna Febi Bilstein i Blue Printa za zapadnu Srbiju.</p>';
    return febi;
  }

  shell() {
    const shell = new Brend();
    shell.ime = 'Shell';
    shell.urlSlikeLogo = 'assets/slike/brendovi/logo/shell.png';
    shell.urlSlikePozadina = 'assets/slike/brendovi/pagepaper/shell.png';
    shell.opis = '<p> Kompanije Shell ima iza sebe 70 godina u inovacijama i stoga je broj jedan dobavljač lubrikanata. Poznata činjenica je da neki od  svetskih proizvođaća automobila preferiraju Shell motorno ulje prvo punjenje novih vozila koja izlaze iz fabike. Kompletan asortiman uključujući sintetičke proizvode visokih performansi može da zadovolji sve poterbe i aplikacije koje vam trebaju.</p><p>AUTOMATERIJAL d.o.o je ovlašceni distributer Shell ulja. </p>'
    return shell;
  }

  victorReinz() {
    const vr = new Brend();
    vr.ime = 'Victor Reinz';
    vr.urlSlikeLogo = 'assets/slike/brendovi/logo/vik.png';
    vr.urlSlikePozadina = 'assets/slike/brendovi/pagepaper/victor-reinz.png';
    vr.opis = '<p> Victor Reinz je Nemačka kompanija koja donosi inovativne tehnologije zaptivanja vrhunskog kvaliteta. Više od 80 godina brend Victor Reinz je sinonim za vrhunske zaptivače i semeringe. Svi rezervni delovi u asortimanu ispunjavaju visoke standarde kvaliteta OEM. Poslednjih godina na tržištu su zauzeli vodeću poziciju, kao proizvođači dihtunga glave, garniture dihtunga i semeringa.</p><p > Skoro sve poznate marke i modeli proizvođača automobila širom sveta su opremljeni sa profesionalnim zaptivnim rešenjima iz Victor Reinza u oblasti motora i izduvnih grasova.</p>'
    return vr;
  }

  mahle() {
    const mahle = new Brend();
    mahle.ime = 'Mahle';
    mahle.urlSlikeLogo = 'assets/slike/brendovi/logo/mahle.png';
    mahle.urlSlikePozadina = 'assets/slike/brendovi/pagepaper/mahle.png';
    mahle.opis = '<p>Marka MAHLE označava rezervne delove u kvalitetu originalne opreme duž celog pogonskog sklopa - od komponenti motora, filtracije i perifernih uređaja motora do upravljanja toplotom i mehatronike. Takođe predstavlja visokokvalitetnu specijalnu opremu za održavanje i servis. </p> <p>Marka je podržana od strane MAHLE-a, vodećeg svetskog dobavljača automobilske opreme, koji snabdeva tržište automobilske opreme visokokvalitetnim proizvodima zahvaljujući OE kompetenciji, vodeći istraživački i razvojni rad, kao i svoju međunarodnu logističku mrežu. </p>'
    return mahle;
  }

  kolbenschmidt() {
    const kolbenschmidt = new Brend();
    kolbenschmidt.ime = 'Kolbenschmidt';
    kolbenschmidt.urlSlikeLogo = 'assets/slike/brendovi/logo/ks.png';
    kolbenschmidt.urlSlikePozadina = 'assets/slike/brendovi/pagepaper/ks.png';
    kolbenschmidt.opis = '<p> Kolbenschmidt razvija i proizvodi klipove za benzin i dizel motore za putnicka i teretna vozila. Jedan je od najistaknutijih igraca u ovom segmentu. Ostali proizvodi uključuju ventile, vođice ventila, karike, ležajeve radilica, bregaste osovine.. </p> <p class="probam">Smanjenje potrošnje goriva i emisija izduvnih gasova su godinama glavni pokretač razvoja  novih vrsta klipova.</p> <p class="proba"> Već godinama, mnogi važni dileri originalnih delova su redovne mušterije Kolbenschmidt-a. Glavna tržišta su Evropa, Serverna i Južna Amerika, i Azija.';
    return kolbenschmidt;
  }

  pierburg() {
    const pierburg = new Brend();
    pierburg.ime = 'Pierburg';
    pierburg.urlSlikeLogo = 'assets/slike/brendovi/logo/pirb.png';
    pierburg.urlSlikePozadina = 'assets/slike/brendovi/pagepaper/pb.png';
    pierburg.opis = '<p>Pierburg, kao dobavljač prve klase, tradicionalno je jedan od najbližih partnera u autobomilskoj industriji. Osnovan je 1909. godine, kao trgovina čelika u Berlinu. 1928. godine počinje sa proizvodnjom karburatora i uskoro postaje jedini snabdevač svih nemačkih automobila i mnogih svetskih proizvođača motornih vozila i proizvođača motora. Pierburg razvija inovativne komponente i sistemska rešenja sa priznatim nadležnostima u oblasti dovoda vazduha i kontrole emisija. Svi ovi proizvodi, pumpe goriva, egr ventil, nepovratni ventil, protokomeri o vakuum pumpe, odgovaraju visokim zahtevima tržišta i standardima kvaliteta.</p> <p> Kako u prošlosti tako i sad, Pierburg aktivno oblikuje budućnost automobila.</p>';
    return pierburg;
  }

  mm() {
    const mm = new Brend();
    mm.ime = 'Magneti Marreli';
    mm.urlSlikeLogo = 'assets/slike/brendovi/logo/mm.png';
    mm.urlSlikePozadina = 'assets/slike/brendovi/pagepaper/magneti-marelli.png';
    mm.opis = '<p>Magneti Mareilli je međunarodna grupa posvećena projektovanju i proizvodnji sistema visoke tehnologije i komponenti za automobilsku indrustriju. Osnovana je 1919. godine, sa kapitalom potpisana na dva jednaka dela između Fiat-a i kompanije Ercole Marelli. Sa 38.000 zaposlenih, 89 proizvodnih pogona, prisutni su u 19 zemalja i snabdevaju sve najvažnije proizvođače u Evropi, Severnoj i Južnoj Americi i Aziji. Cilj Magenti Marelli-ja je da bude na raspolaganju kupcima po pristupačnoj ceni, spajanjem visokog kvaliteta i visoke tehnologije.</p> <p> Magneti Marelli je prvi stvorio ksenonsko svetlo 1991. godine, dajući novu dimenziju frontalnoj rasvetli. Od 2010. godine, postaje dobavljač Mercedes-Benz za sve LED farove sa prilagodljivom funkcijom za svetlo.</p> <p>2010. godine Ministartsvo za kulturnu baštinu i aktivnost Italije nagrađuje Magneti Marelli sa "Deklaracija o istorijskom značaju".</p>';
    return mm;
  }

  bluePrint() {
    const bp = new Brend();
    bp.ime = 'Blue Print';
    bp.urlSlikeLogo = 'assets/slike/brendovi/logo/bp.png';
    bp.urlSlikePozadina = 'assets/slike/brendovi/pagepaper/blueprint.png';
    bp.opis = '<p>Blue Print je pravi izbor za kvalitetne rezervne delove za azijske, američke, britanske automobile i laka komercijalna vozila. Blue Print pruža aftermarket visoko preciznim komponentama kao i tehničkim i informacijskim rešenjima za više od 160 različitih tipova proizvoda.</p> <p>Širok asortiman od više od 23.000 artikala dostupnih u preko 160 vrsta proizvoda pod jednom robnom markom, uključujući i OE proizvode svrstava Blue Print kao jednog od brendova sa najvećom ponudom na tržištu.</p>';
    return bp;
  }
}
