import { Component, OnInit } from '@angular/core';
import { Poruka, Upit } from 'src/app/e-commerce/model/dto';
import { Validators, FormBuilder, FormGroup, RequiredValidator } from '@angular/forms';
import { MatDialogRef, MatSnackBar } from '@angular/material';
import { EmailService } from 'src/app/shared/service/email.service';
import { takeWhile, finalize, catchError } from 'rxjs/operators';
import { throwError, EMPTY } from 'rxjs';

@Component({
  selector: 'app-upit-modal',
  templateUrl: './upit-modal.component.html',
  styleUrls: ['./upit-modal.component.scss']
})
export class UpitModalComponent implements OnInit {

  public upitForm: FormGroup;
  public upitSubmited = false;
  public porukaJePoslata = false;

  private alive = true;
  public ucitavanje = false;
  selectedCar: string;

  selektovanoGorivo: string;
  pogoni = [
    '2WD',
    '4WD'];
  gorivo = [
    'Benzin', 'Dizel', 'Benzin+Gas(TNG)',
    'Metan CNG', 'Električni pogon', 'Električni pogon', 'Hibridni pogon'];
  ponude = [
    'Mali servis', 'Veliki servis', 'Prednje kočnice',
    'Zadnje kočnice', 'Set kvačila', 'Zamajac', 'Drugo'];

  constructor(
    public dialogRef: MatDialogRef<UpitModalComponent>,
    private formBuilder: FormBuilder,
    private emailServis: EmailService,
    public snackBar: MatSnackBar
  ) { }

  ngOnInit() {
    this.inicijalizujForme();
  }

  inicijalizujForme() {
    this.upitForm = this.formBuilder.group({
      marka_model: ['', [Validators.required]],
      godiste: ['', [Validators.required]],
      kubikaza: ['', [Validators.required]],
      kilovati: ['', [Validators.required]],
      gorivo: ['', [Validators.required]],
      pogon: ['', [Validators.required]],
      interesuje_me: ['', [Validators.required]],
      email_telefon: ['', [Validators.required]],
      drugo: ['']
    });
  }
  posaljiUpit() {
    this.upitSubmited = true;
    if (this.upitForm.invalid) {
      return;
    }
    const upit = this.popuniUpit();
    this.emailServis.posaljiUpit(upit)
      .pipe(
        takeWhile(() => this.alive),
        catchError((error: Response) => throwError(error)),
        finalize(() => this.ucitavanje = false)
      ).subscribe(res => {
        console.log('Poruka uspesno poslat');
        this.upitForm.reset();
        this.upitSubmited = false;
        this.porukaJePoslata = true;
        this.otvoriSnackBar('Upit je uspešno poslat');

      }, error => {
        console.log('Error pri slanju poruke', error);
        this.otvoriSnackBar('Došlo je do greške, upit nije poslat');
        this.dialogRef.close();
      });
  }

  popuniUpit(): Upit {
    const upit = new Upit();
    upit.emailTelefon = this.u.email_telefon.value;
    upit.markaModel = this.u.marka_model.value;
    upit.godiste = this.u.godiste.value;
    upit.kubikaza = this.u.kubikaza.value;
    upit.kilovati = this.u.kilovati.value;
    upit.gorivo = this.u.gorivo.value;
    upit.pogon = this.u.pogon.value;
    upit.interesujeMe = this.u.interesuje_me.value;
    if (this.u.drugo.value) {
      upit.drugo = this.u.drugo.value;
    }
    return upit;
  }

  otvoriSnackBar(poruka: string) {
    this.snackBar.open(poruka, '', {
      duration: 2000
    });
  }
  // convenience getter for easy access to form fields
  get u() { return this.upitForm.controls; }

  daLiJeObelezenoDrugo() {
    const interesujeMe = this.u.interesuje_me.value;
    return interesujeMe.includes('Drugo');
  }

  zatvoriUpitDialog() {
    this.dialogRef.close();
  }

}
