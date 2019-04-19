import { Injectable } from '@angular/core';
import { MatSnackBarRef, MatSnackBar } from '@angular/material';

@Injectable({
  providedIn: 'root'
})
export class NotifikacijaService {

  constructor(public snackBar: MatSnackBar) { }

  public notify(poruka: string, klasaBoja: string) {
    this.snackBar.open(poruka, '', {
      duration: 2000,
      panelClass: [klasaBoja]
    });
  }
}
