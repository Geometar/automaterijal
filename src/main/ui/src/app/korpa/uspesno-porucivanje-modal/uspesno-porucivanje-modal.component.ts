import { Component, OnInit, Inject } from '@angular/core';
import { Fakutra } from 'src/app/model/dto';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import * as _ from 'lodash';

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
