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
    sveVesti.push(this.vestiPonuda1(), this.vestiPonuda2());
    return sveVesti;
  }

  vestiPonuda1(): Vest {
    const prva = new Vest();
    prva.id = 'ponuda-generic';
    prva.naslov = '<h1>Ponuda generic</h1>';
    prva.slika = 'https://material.angular.io/assets/img/examples/shiba2.jpg';
    prva.tekst = '<p>Febi bilstein je  osnovan davne 1844 godine. Danas je jedan od vodećih svetskih proizvođača i dobavljača rezervnih delova za putnička i komercijalna vozila na nezavisnom tržištu rezervnih delova.  Više od 170 godina održava kontinuitet, kvalitet, uslugu, pouzdanost i inovacije. Asortiman cini 30.000 razlicitih rezervnih delova. Osim toga, febi ima svoja predstavništva ili iskusnog partnera u preko 69 zemalja. </p> <p>Od upravljačke, motorne i kočne tehnike, tehnike šasija i učvršćivanja točkova do autoelektrike i pneumatike i programa febi plus – kod firme febi bilstein ćete naći sve za profesionalno servisiranje - putničkih vozila, kamiona, autobusa, prikolica, poluprikolica i malih transportera svih aktuelnih marki i modela.</p> <p class="proba">Febi bilstein stoji za proizvode koji ispunjavaju najviše zahteve kvaliteta izrade i bezbednosti ugradnje. Kvalitetom, brzinom i postavljanjem trendova febi bilstein vam daje odlučujući podsticaj na globalnom tržištu. Zato što kao premium marka ima obavezu da ispuni zahteve svojih kupaca – svakodnevno.</p> <p>AUTOMATERIJAL d.o.o - je zastupnik koncerna Febi Bilstein i Blue Printa za zapadnu Srbiju.</p>';
    return prva;
  }

  vestiPonuda2(): Vest {
    const prva = new Vest();
    prva.id = 'ponuda-generic 2';
    prva.naslov = 'Ponuda generic 2';
    prva.tekst = 'Opis Vesti ide ovde. 2';
    prva.slika = 'https://material.angular.io/assets/img/examples/shiba2.jpg';
    return prva;
  }

}
