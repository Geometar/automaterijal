import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { OstaloComponent } from './ostalo.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { MaterialModule } from 'src/app/shared/material/material.module';
import { SharedMagacinModule } from '../shared-components/shared-magacin.module';
import { PipeModule } from 'src/app/shared/pipes/pipe.module';

const routes: Routes = [
  {
    path: '',
    component: OstaloComponent
  }
];
@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    MaterialModule,
    SharedMagacinModule,
    PipeModule,
    RouterModule.forChild(routes)
  ],
  declarations: [OstaloComponent],
  exports: [OstaloComponent]
})
export class OstaloModule { }
