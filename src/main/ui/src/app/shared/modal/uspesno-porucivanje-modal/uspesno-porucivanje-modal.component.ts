import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import * as _ from 'lodash';
import { Fakutra } from 'src/app/e-shop/model/dto';

@Component({
  selector: 'app-uspesno-porucivanje-modal',
  templateUrl: './uspesno-porucivanje-modal.component.html',
  styleUrls: ['./uspesno-porucivanje-modal.component.scss']
})
export class UspesnoPorucivanjeModalComponent implements OnInit {

  public data: Fakutra;
  constructor(
    public dialogRef: MatDialogRef<UspesnoPorucivanjeModalComponent>,
    @Inject(MAT_DIALOG_DATA) public faktura: Fakutra) {}

  ngOnInit() {
    this.data = this.faktura;
  }

  zatvori() {
    this.dialogRef.close();
  }

}
