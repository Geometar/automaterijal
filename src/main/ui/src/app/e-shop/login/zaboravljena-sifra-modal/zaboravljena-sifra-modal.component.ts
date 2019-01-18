import { Component, OnInit } from '@angular/core';
import { MatDialogRef, MatSnackBar } from '@angular/material';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EmailService } from '../../service/email.service';
import { takeWhile, finalize, catchError } from 'rxjs/operators';
import { throwError, EMPTY } from 'rxjs';
import { ResetSifre } from '../../model/dto';

@Component({
  selector: 'app-zaboravljena-sifra-modal',
  templateUrl: './zaboravljena-sifra-modal.component.html',
  styleUrls: ['./zaboravljena-sifra-modal.component.scss']
})
export class ZaboravljenaSifraModalComponent implements OnInit {

  public resetSifre: ResetSifre = new ResetSifre();
  public mailUspesnoPoslat = false;

  // forme
  public zaboravljeSifraForma: FormGroup;
  public formaSubmited = false;

  private alive = true;
  public ucitavanje = false;
  constructor(
    public dialogRef: MatDialogRef<ZaboravljenaSifraModalComponent>,
    private formBuilder: FormBuilder,
    private emailService: EmailService,
    public snackBar: MatSnackBar) { }

  ngOnInit() {
    this.inicijalizujSveRegistracioneForme();
  }
  inicijalizujSveRegistracioneForme() {
    this.zaboravljeSifraForma = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
    });
  }

  posaljiMailZaboravljenaSifra() {
    this.formaSubmited = true;
    if (this.zaboravljeSifraForma.invalid) {
      return;
    }
    this.resetSifre.email = this.zaboravljeno.email.value;
    this.emailService
    .posaljiMailZaResetovanjeSifre(this.resetSifre)
    .pipe(
      takeWhile(() => this.alive),
      catchError((error: Response) => {
        if (error.status === 400) {
          const snackPoruka = 'Mail ne postoji u našoj bazi.';
          this.otvoriSnackBar(snackPoruka);
          return EMPTY;
        }
        throwError(error);
      }),
      finalize(() => this.ucitavanje = false)
    ).subscribe(res => {
      this.mailUspesnoPoslat = true;
      console.log('Mail za resetovanje sifre uspesno poslat');
    }, error => {
      console.log('Error pri slanju za resetovanje sifre', error);
    });
  }

  zatvoriDialog() {
    this.dialogRef.close();
  }

  // convenience getter for easy access to form fields
  get zaboravljeno() { return this.zaboravljeSifraForma.controls; }

  otvoriSnackBar(poruka: string) {
    this.snackBar.open(poruka, '', {
      duration: 2000,
      panelClass: ['my-snack-bar']
    });
  }
}
