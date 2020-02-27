import { Component, OnInit } from '@angular/core';
import { RobaService } from '../../service/roba.service';
import { Params, ActivatedRoute } from '@angular/router';
import { RobaDetalji } from '../../model/dto';
import { takeWhile, finalize, catchError } from 'rxjs/operators';
import { throwError, EMPTY } from 'rxjs';
import { HttpResponse } from '@angular/common/http';

@Component({
  selector: 'app-roba-detalji',
  templateUrl: './roba-detalji.component.html',
  styleUrls: ['./roba-detalji.component.scss']
})
export class RobaDetaljiComponent implements OnInit {

  public robaDetalji: RobaDetalji;

  public ucitavanje = false;
  private alive = true;

  constructor(
    private robaService: RobaService,
    private route: ActivatedRoute
    ) { }

  ngOnInit() {
    this.uzmiDetaljeRobe();
  }

  uzmiDetaljeRobe() {
    this.ucitavanje = true;
    this.route.params.subscribe((params: Params) => {
      this.robaService.pronadjiDetaljeRobe(params.id)
      .pipe(
        takeWhile(() => this.alive),
        catchError((error: Response) => {
          if (error.status === 404) {
            console.log('404 vratili detalji');
            return EMPTY;
          }
          return throwError(error);
        }),
        finalize(() => this.ucitavanje = false))
      .subscribe((res: HttpResponse<RobaDetalji>) => {
        this.robaDetalji = res.body;
        console.log(this.robaDetalji);
      });
    });

  }

}
