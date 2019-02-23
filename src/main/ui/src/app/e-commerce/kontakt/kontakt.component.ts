import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EmailService } from 'src/app/shared/service/email.service';
import { takeWhile, finalize, catchError } from 'rxjs/operators';
import { throwError, EMPTY } from 'rxjs';
import { MatSnackBar } from '@angular/material';
import { Poruka } from '../model/dto';

@Component({
  selector: 'app-kontakt',
  templateUrl: './kontakt.component.html',
  styleUrls: ['./kontakt.component.scss']
})
export class KontaktComponent implements OnInit {
  public porukaForm: FormGroup;
  public porukaSubmited = false;

  private alive = true;
  public ucitavanje = false;

  ngOnInit() {
    this.inicijalizujForme();
    }

  constructor(
    private formBuilder: FormBuilder,
    private emailServis: EmailService,
    public snackBar: MatSnackBar
  ) {}

  inicijalizujForme() {
    this.porukaForm = this.formBuilder.group({
      ime: [''],
      prezime: [''],
      firma: [''],
      telefon: [''],
      posta: ['', [Validators.required, Validators.email]],
      poruka: ['', [Validators.required, Validators.minLength(3)]]
    });
  }

  posaljiPoruku() {
    this.porukaSubmited = true;
    if (this.porukaForm.invalid) {
      return;
    }
    const poruka = this.popuniPoruku();
    this.emailServis.posaljiPoruku(poruka)
    .pipe(
      takeWhile(() => this.alive),
      catchError((error: Response) =>  throwError(error)),
      finalize(() => this.ucitavanje = false)
    ).subscribe(res => {
      console.log('Poruka uspesno poslat');
      this.otvoriSnackBar('Poruka uspešno poslatata');
      this.porukaForm.reset();
      this.porukaSubmited = false;
    }, error => {
      console.log('Error pri slanju poruke', error);
      this.otvoriSnackBar('Poruka nije poslata, pokusajte kasnije.');
    });
  }

  popuniPoruku(): Poruka {
    const poruka = new Poruka();
    poruka.ime = this.p.ime.value;
    poruka.prezime = this.p.prezime.value;
    poruka.firma = this.p.firma.value;
    poruka.telefon = this.p.telefon.value;
    poruka.posta = this.p.posta.value;
    poruka.poruka = this.p.poruka.value;
    return poruka;
  }
  // convenience getter for easy access to form fields
  get p() { return this.porukaForm.controls; }


  otvoriSnackBar(poruka: string) {
    this.snackBar.open(poruka, '', {
      duration: 2000
    });
  }
  otvoriErrorSnackBar(poruka: string) {
    this.snackBar.open(poruka, '', {
      duration: 2000,
      panelClass: ['my-snack-bar']
    });
  }
}
