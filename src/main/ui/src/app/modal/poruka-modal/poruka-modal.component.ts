import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { Poruka } from 'src/app/e-commerce/model/dto';
import { takeWhile, finalize, catchError } from 'rxjs/operators';
import { throwError, EMPTY } from 'rxjs';
import { EmailService } from 'src/app/shared/service/email.service';
import { MatSnackBar, MatDialogRef } from '@angular/material';

@Component({
  selector: 'app-poruka-modal',
  templateUrl: './poruka-modal.component.html',
  styleUrls: ['./poruka-modal.component.scss']
})
export class PorukaModalComponent implements OnInit {
  public porukaForm: FormGroup;
  public porukaSubmited = false;

  private alive = true;
  public ucitavanje = false;

  constructor(
    public dialogRef: MatDialogRef<PorukaModalComponent>,
    private formBuilder: FormBuilder,
    private emailServis: EmailService,
    public snackBar: MatSnackBar
    ) { }

  ngOnInit() {
    this.inicijalizujForme();
  }

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
      this.porukaForm.reset();
      this.porukaSubmited = false;
      this.otvoriSnackBar('Poruka je uspešno poslata');
      this.dialogRef.close();
    }, error => {
      console.log('Error pri slanju poruke', error);
      this.otvoriSnackBar('Došlo je do greške, poruka nije poslata');
      this.dialogRef.close();
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

  zatvoriDialog() {
    this.dialogRef.close();
  }

}
