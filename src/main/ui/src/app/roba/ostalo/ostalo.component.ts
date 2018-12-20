import { Component, OnInit } from '@angular/core';
import { RobaService } from 'src/app/service/roba.service';
import { takeWhile, finalize, catchError } from 'rxjs/operators';
import { throwError, EMPTY } from 'rxjs';

@Component({
  selector: 'app-ostalo',
  templateUrl: './ostalo.component.html',
  styleUrls: ['./ostalo.component.scss']
})
export class OstaloComponent implements OnInit {

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
          console.log('Podnaci kategorije je izbacilo je gresko');
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

}
