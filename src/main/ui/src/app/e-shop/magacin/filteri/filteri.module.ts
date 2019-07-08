import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { FilteriComponent } from './filteri.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { MaterialModule } from 'src/app/shared/material/material.module';
import { SharedMagacinModule } from '../shared-components/shared-magacin.module';

const routes: Routes = [
  {
    path: '',
    component: FilteriComponent
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
  declarations: [FilteriComponent],
  exports: [FilteriComponent]
})
export class FilteriModule { }
