import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-kategorije',
  templateUrl: './kategorije.component.html',
  styleUrls: ['./kategorije.component.scss']
})
export class KategorijeComponent implements OnInit {

  public motornaKategorija: Kategorije[] = [];

  constructor(private router: Router) { }

  ngOnInit(): void {
    this.kategorijaUlja();
  }

  kategorijaUlja() {
    const motornaUlja = new Kategorije();
    motornaUlja.naslov = 'Motorna ulja';
    motornaUlja.slikaId = 'assets/slike/kategorije/m-ulje.jpg';
    motornaUlja.url = 'motorna_ulja';
    this.motornaKategorija.push(motornaUlja);

    const menjackoUlje = new Kategorije();
    menjackoUlje.naslov = 'Menjačko ulje';
    menjackoUlje.slikaId = 'assets/slike/kategorije/menjacko-ulje.png';
    menjackoUlje.url = 'menjacka_ulja';
    this.motornaKategorija.push(menjackoUlje);

    const antifrim = new Kategorije();
    antifrim.naslov = 'Antifriz';
    antifrim.slikaId = 'assets/slike/kategorije/a-ulje.jpg';
    antifrim.url = 'antifriz';
    this.motornaKategorija.push(antifrim);

    const kocionoUlje = new Kategorije();
    kocionoUlje.naslov = 'Kociono ulje';
    kocionoUlje.slikaId = 'assets/slike/kategorije/k-ulje.jpg';
    kocionoUlje.url = 'kociono_ulje';
    this.motornaKategorija.push(kocionoUlje);

    const motocikliUlje = new Kategorije();
    motocikliUlje.naslov = 'Dvotaktol ulje';
    motocikliUlje.slikaId = 'assets/slike/kategorije/d-ulje.jpg';
    motocikliUlje.url = 'dvotaktol';
    this.motornaKategorija.push(motocikliUlje);

    const industrijskaUlja = new Kategorije();
    industrijskaUlja.naslov = 'Industrijska ulja';
    industrijskaUlja.slikaId = 'assets/slike/kategorije/i-ulje.jpg';
    industrijskaUlja.url = 'industrijska_ulja';
    industrijskaUlja.podkategorije = [
      'Hidraulično ulje',
      'Kompresorsko ulje',
      'Reduktorsko ulje',
      'Transformatorsko ulje',
      'Turbinska ulja',
      'Ulja za pneumatske alate',
      'Ulja za klizne staze',
      'Ulja za prenos toplote'];
    this.motornaKategorija.push(industrijskaUlja);

  }

  izabranaPodKategorija(kategorija: Kategorije, podkategorija: string) {
    const url = '/kategorije/' + kategorija.url;
    this.router.navigate([url], { queryParams: { grupa: podkategorija } });
  }

}

class Kategorije {
  slikaId?: string;
  naslov?: string;
  url?: string;
  podkategorije?: string[];
}
