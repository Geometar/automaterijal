import { Component, OnInit, OnDestroy } from '@angular/core';
import { takeWhile, finalize, catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { RobaService } from '../../service/roba.service';

@Component({
  selector: 'app-ostalo',
  templateUrl: './ostalo.component.html',
  styleUrls: ['./ostalo.component.scss']
})
export class OstaloComponent implements OnInit, OnDestroy {

  public kategorije: string[];
  private alive = true;
  public ucitavanje = false;
  public pocetnaSlova = ['A', 'B', 'C', 'D', 'G', 'H', 'Z', 'I', 'K', 'L', 'M', 'P', 'R', 'S', 'T', 'V', 'Z'];

  constructor(private robaServis: RobaService) { }

  ngOnInit() {
    this.robaServis.ostaleKategorije().pipe(
      takeWhile(() => this.alive),
      catchError((error: Response) => throwError(error)),
      finalize(() => this.ucitavanje = false)
    )
      .subscribe(
        res => {
          this.kategorije = res;
        },
        error => {
        });
  }

  vratiKategorijuNaSlovo(slovo: string): string[] {
    const kategorije = [];
    this.kategorije.forEach(kategorija => {
      if (kategorija[0] === slovo) {
        kategorije.push(kategorija);
      }
    });
    return kategorije;
  }


  ngOnDestroy() {
    this.alive = false;
  }

}
