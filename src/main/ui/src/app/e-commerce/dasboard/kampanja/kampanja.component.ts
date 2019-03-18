import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { VestiNaslovna } from '../../model/dto';

@Component({
  selector: 'app-kampanja',
  templateUrl: './kampanja.component.html',
  styleUrls: ['./kampanja.component.scss']
})
export class KampanjaComponent implements OnInit {

  constructor(private router: Router) { }

  public ponuda = [];

  ngOnInit() {
    this.vratiSvePonude();
  }
  detaljiVesti(id: string) {
    this.router.navigate(['/naslovna/' + id]);
  }

  vratiSvePonude() {
    const ponuda1 = this.ponuda1();
    const ponuda2 = this.ponuda1();
    const ponuda3 = this.ponuda1();
    const ponuda4 = this.ponuda1();
    this.ponuda.push(ponuda1, ponuda2, ponuda3, ponuda4);
  }

  ponuda1(): VestiNaslovna {
    const prva = new VestiNaslovna();
    prva.id = 'ponuda-generic';
    prva.naslov = 'Ponuda generic';
    prva.opis = 'Opis Vesti ide ovde.';
    prva.opisSlika = 'https://material.angular.io/assets/img/examples/shiba2.jpg';
    return prva;
  }

}
