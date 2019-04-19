import { Component, OnInit } from '@angular/core';
import { VestiNaslovna } from '../../model/dto';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ponuda',
  templateUrl: './ponuda.component.html',
  styleUrls: ['./ponuda.component.scss']
})
export class PonudaComponent implements OnInit {

  constructor(private router: Router) { }

  public ponuda = [];

  ngOnInit() {
    this.vratiSvePonude();
  }
  detaljiVesti(id: string) {
    this.router.navigate(['/naslovna/' + id]);
  }

  vratiSvePonude() {
    const shell = this.shell();
    const febi = this.febi();
    const mahle = this.mahle();
    const ks = this.ks();
    this.ponuda.push(shell, febi, mahle, ks);
  }

  shell(): VestiNaslovna {
    const shell = new VestiNaslovna();
    shell.id = 'shell-u-ponudi';
    shell.naslov = 'Shell';
    shell.opis = 'Opis Shell-a ide ovde. SINOVAC SE CEKA';
    shell.opisSlika = 'assets/slike/novouponudi/mala/shell.png';
    return shell;
  }

  febi(): VestiNaslovna {
    const febi = new VestiNaslovna();
    febi.id = 'febi-u-ponudi';
    febi.naslov = 'Febi';
    febi.opis = 'Opis Febi-a ide ovde. SINOVAC SE CEKA';
    febi.opisSlika = 'assets/slike/novouponudi/mala/febi.png';
    return febi;
  }

  mahle(): VestiNaslovna {
    const mahle = new VestiNaslovna();
    mahle.id = 'mahle-u-ponudi';
    mahle.naslov = 'Mahle';
    mahle.opis = 'Opis Mahle-a ide ovde. SINOVAC SE CEKA';
    mahle.opisSlika = 'assets/slike/novouponudi/mala/mahle.png';
    return mahle;
  }

  ks(): VestiNaslovna {
    const ks = new VestiNaslovna();
    ks.id = 'ks-u-ponudi';
    ks.naslov = 'Ks';
    ks.opis = 'Opis Ks-a ide ovde. SINOVAC SE CEKA';
    ks.opisSlika = 'assets/slike/novouponudi/mala/ks.png';
    return ks;
  }

}
