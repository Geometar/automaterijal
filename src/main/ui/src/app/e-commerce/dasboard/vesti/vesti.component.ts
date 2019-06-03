import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { VestiNaslovna } from '../../model/dto';

@Component({
  selector: 'app-vesti',
  templateUrl: './vesti.component.html',
  styleUrls: ['./vesti.component.scss']
})
export class VestiComponent implements OnInit {

  constructor(private router: Router) { }

  public ponuda = [];

  ngOnInit() {
    this.vratiSvePonude();
  }
  detaljiVesti(id: string) {
    this.router.navigate(['/naslovna/' + id]);
  }

  vratiSvePonude() {
    const mahlePakovanjeVest = this.vestNovoPakovanjeMahle();
    const mahleKompresori = this.vestMahleKompresori();
    this.ponuda.push(mahlePakovanjeVest, mahleKompresori);
  }

  vestNovoPakovanjeMahle() {
    const vest = new VestiNaslovna();
    vest.id = 'mahle-pakovanje';
    vest.naslov = 'Novo Pakovanje Mahle';
    vest.opis = 'Novi dizajn ambalaže za MAHLE Aftermarket proizvode od 2019. godine';
    vest.opisSlika = 'assets/slike/novouponudi/mala/mahle-pakovanja.png';
    return vest;
  }

  vestMahleKompresori() {
    const vest = new VestiNaslovna();
    vest.id = 'mahle-kompresori';
    vest.naslov = 'Mahle kompresori klime';
    vest.opis = 'Novo u asortimanu - kompresori klime Mahle';
    vest.opisSlika = 'assets/slike/novouponudi/mala/kompresori.png';
    return vest;
  }
}
