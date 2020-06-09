import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Brend } from 'src/app/e-commerce/model/dto';

@Component({
  selector: 'app-brendovi-modal',
  templateUrl: './brendovi-modal.component.html',
  styleUrls: ['./brendovi-modal.component.scss']
})
export class BrendoviModalComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<BrendoviModalComponent>,
    @Inject(MAT_DIALOG_DATA) public brend: Brend) { }

  ngOnInit() {
  }

  zatvoriDialog() {
    this.dialogRef.close();
  }

}
