import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { MaterialModule } from 'src/app/shared/material/material.module';
import { RouterModule, Routes } from '@angular/router';
import { AkumulatoriComponent } from './akumulatori.component';
import { SharedMagacinModule } from '../shared-components/shared-magacin.module';

const routes: Routes = [
  {
    path: '',
    component: AkumulatoriComponent
  }
];

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    MaterialModule,
    SharedMagacinModule,
    RouterModule.forChild(routes)
  ],
  declarations: [AkumulatoriComponent],
  exports: [AkumulatoriComponent]
})
export class AkumulatoriModule { }
