import { Component, OnInit } from '@angular/core';
import { Brend } from '../model/dto';

@Component({
  selector: 'app-dasboard',
  templateUrl: './dasboard.component.html',
  styleUrls: ['./dasboard.component.css']
})
export class DasboardComponent implements OnInit {
  images = [1, 2, 3].map(() => `https://picsum.photos/900/500?random&t=${Math.random()}`);
  public mySlideBrands = this.vratiSveSlajdove();
  public mySlideOptions = {
    animateOut: 'slideOutDown',
    animateIn: 'flipInX',
    items: 1, margin: 0,
    dots: false, nav: true, autoplay: true,
    autoplayTimeout: 2500, rewind: true};

  vratiSveSlajdove() {
    const nizOdBrendova = [];
    const febi = this.febi();
    const shell = this.shell();
    nizOdBrendova.push(febi, shell);
    return nizOdBrendova;
  }

  febi() {
    const febi = new Brend();
    febi.ime = 'Febi';
    febi.urlSlikeLogo = 'assets/slike/brendovi/logo/febi.jpg';
    febi.urlSlikePozadina = 'assets/slike/brendovi/pagepaper/febi.png';
    febi.opis = '<p>Febi bilstein je  osnovan davne 1844 godine. Danas je jedan od vodećih svetskih proizvođača i dobavljača rezervnih delova za putnička i komercijalna vozila na nezavisnom tržištu rezervnih delova.  Više od 170 godina održava kontinuitet, kvalitet, uslugu, pouzdanost i inovacije. Asortiman cini 30.000 razlicitih rezervnih delova. Osim toga, febi ima svoja predstavništva ili iskusnog partnera u preko 69 zemalja. </p> <p>Od upravljačke, motorne i kočne tehnike, tehnike šasija i učvršćivanja točkova do autoelektrike i pneumatike i programa febi plus – kod firme febi bilstein ćete naći sve za profesionalno servisiranje - putničkih vozila, kamiona, autobusa, prikolica, poluprikolica i malih transportera svih aktuelnih marki i modela.</p> <p class="proba">Febi bilstein stoji za proizvode koji ispunjavaju najviše zahteve kvaliteta izrade i bezbednosti ugradnje. Kvalitetom, brzinom i postavljanjem trendova febi bilstein vam daje odlučujući podsticaj na globalnom tržištu. Zato što kao premium marka ima obavezu da ispuni zahteve svojih kupaca – svakodnevno.</p> <p>AUTOMATERIJAL d.o.o - je zastupnik koncerna Febi Bilstein i Blue Printa za zapadnu Srbiju.</p>';
    return febi;
   }

   shell() {
    const shell = new Brend();
    shell.ime = 'Shell';
    shell.urlSlikeLogo = 'assets/slike/brendovi/logo/shell.jpg';
    shell.urlSlikePozadina = 'assets/slike/brendovi/pagepaper/shell.png';
    shell.opis = '<p> Kompanije Shell ima iza sebe 70 godina u inovacijama i stoga je broj jedan dobavljač lubrikanata. Poznata činjenica je da neki od  svetskih proizvođaća automobila preferiraju Shell motorno ulje prvo punjenje novih vozila koja izlaze iz fabike. Kompletan asortiman uključujući sintetičke proizvode visokih performansi može da zadovolji sve poterbe i aplikacije koje vam trebaju.</p><p>AUTOMATERIJAL d.o.o je ovlašceni distributer Shell ulja. </p>'
     return shell;
   }

  ngOnInit() {

  }constructor() {
  }
}
