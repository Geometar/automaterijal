import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RobaDetaljiComponent } from './roba-detalji.component';
import { MaterialModule } from 'src/app/shared/material/material.module';

@NgModule({
  imports: [
    CommonModule,
    MaterialModule,
  ],
  declarations: [RobaDetaljiComponent],
  exports: [RobaDetaljiComponent]
})
export class RobaDetaljiModule { }
