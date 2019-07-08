import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { MaterialModule } from 'src/app/shared/material/material.module';
import { SharedMagacinModule } from '../shared-components/shared-magacin.module';
import { UljaComponent } from './ulja.component';
import { Routes, RouterModule } from '@angular/router';
import { MotornaComponent } from './motorna/motorna.component';
import { AntifrizComponent } from './antifriz/antifriz.component';
import { MenjackoComponent } from './menjacko/menjacko.component';
import { IndustrijskaComponent } from './industrijska/industrijska.component';
import { KocionaComponent } from './kociona/kociona.component';

const routes: Routes = [
  {
    path: '',
    component: UljaComponent
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
  declarations: [
    UljaComponent,
    MotornaComponent,
    AntifrizComponent,
    MenjackoComponent,
    KocionaComponent,
    IndustrijskaComponent,
    AntifrizComponent],
  exports: [
    UljaComponent,
    MotornaComponent,
    AntifrizComponent,
    MenjackoComponent,
    KocionaComponent,
    IndustrijskaComponent,
    AntifrizComponent],
})
export class UljaModule { }
