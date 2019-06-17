import { Component, OnInit, Inject } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { PartnerService } from 'src/app/e-shop/service/partner.service';
import { PromenaSifre, Partner } from 'src/app/e-shop/model/dto';
import { takeWhile, finalize, catchError } from 'rxjs/operators';
import { throwError, EMPTY } from 'rxjs';

@Component({
  selector: 'app-prvo-logovanje-modal',
  templateUrl: './prvo-logovanje-modal.component.html',
  styleUrls: ['./prvo-logovanje-modal.component.scss']
})
export class PrvoLogovanjeModalComponent implements OnInit {

  public promenaSifreForm: FormGroup;
  public submitted = false;
  public partner: Partner;

  private alive = true;
  public uspesnaPromena = true;
  public ucitavanje = false;

  constructor(
    public dialogRef: MatDialogRef<PrvoLogovanjeModalComponent>,
    private partnerServis: PartnerService,
    private formBuilder: FormBuilder,
    @Inject(MAT_DIALOG_DATA) public data) { }

  ngOnInit() {
    this.partner = this.data;
    this.inicijalizujForme();
  }

  inicijalizujForme() {
    this.promenaSifreForm = this.formBuilder.group({
      pass1: ['', [Validators.required, Validators.minLength(3)]],
      pass2: ['', [Validators.required, Validators.minLength(3)]]
    }, { validator: this.proveriSifre });
  }

  proveriSifre(group: FormGroup) {
    const pass = group.controls.pass1.value;
    const confirmPass = group.controls.pass2.value;

    return pass === confirmPass ? null : { notSame: true };
  }

  promeniSifru() {
    this.submitted = true;
    if (this.promenaSifreForm.invalid || this.r.pass1.value !== this.r.pass2.value) {
      return;
    }
    this.pozoviServisIPromeniSifru();
  }

  pozoviServisIPromeniSifru() {
    const dto = this.napraviDto();
    this.partnerServis.promeniSifru(dto, true).pipe(
      takeWhile(() => this.alive),
      catchError((error: Response) => {
        if (error.status === 400) {
          this.uspesnaPromena = false;
          return EMPTY;
        }
        return throwError(error);
      }),
      finalize(() => this.ucitavanje = false)
    )
      .subscribe(
        () => {
          this.uspesnaPromena = true;
        },
        () => {
          this.uspesnaPromena = false;
        });

  }

  zatvoriDialog() {
    this.dialogRef.close();
  }

  private napraviDto(): PromenaSifre {
    const dto = new PromenaSifre();
    dto.sifra = this.r.pass1.value;
    dto.ponovljenjaSifra = this.r.pass2.value;
    dto.ppid = 933;
    return dto;
  }

  get r() { return this.promenaSifreForm.controls; }

}
