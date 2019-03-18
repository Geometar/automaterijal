import { Component, OnInit } from '@angular/core';
import { MatDialog, MatSnackBar } from '@angular/material';
import { RegistracijaModalComponent } from '../modal/registracija-modal/registracija-modal.component';
import { ZaboravljenaSifraModalComponent } from '../modal/zaboravljena-sifra-modal/zaboravljena-sifra-modal.component';
import { PorukaModalComponent } from '../modal/poruka-modal/poruka-modal.component';
import { UpitModalComponent } from '../modal/upit-modal/upit-modal.component';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss']
})
export class FooterComponent implements OnInit {

  public img_logo = '/assets/slike/logo/automaterijal.png';
  constructor(
    public dialog: MatDialog,
    public snackBar: MatSnackBar
    ) { }

  ngOnInit() {
  }

  otvoriPorukuDialog() {
    const dialogRef = this.dialog.open(PorukaModalComponent, {
      width: '400px'
    });
  }

  otvoriResgracijaDialog() {
    const dialogRef = this.dialog.open(RegistracijaModalComponent, {
      width: '400px'
    });
  }
  otvoriZaboravljenuSifruDialog() {
    const dialogRef = this.dialog.open(ZaboravljenaSifraModalComponent, {
      width: '400px'
    });
  }
  otvoriSnackBar(poruka: string) {
    this.snackBar.open(poruka, '', {
      duration: 2000
    });
  }

  otvoriUpitDialog() {
    const dialogRef = this.dialog.open(UpitModalComponent, {
      width: '400px'
    });
  }
}
