import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DasboardComponent } from './dasboard.component';
import { ClanakComponent } from './clanak/clanak.component';
import { PonudaComponent } from './ponuda/ponuda.component';
import { VestiComponent } from './vesti/vesti.component';
import { CarouselModule } from 'ngx-bootstrap/carousel';
import { OwlModule } from 'ngx-owl-carousel';
import { MaterialModule } from 'src/app/shared/material/material.module';

const routes: Routes = [
  {
    path: '',
    component: DasboardComponent
  },
  {
    path: ':id',
    component: ClanakComponent
  },
];

@NgModule({
  imports: [
    CarouselModule,
    OwlModule,
    MaterialModule,
    RouterModule.forChild(routes)
  ],
  declarations: [DasboardComponent, ClanakComponent, PonudaComponent, VestiComponent],
  exports: [DasboardComponent]
})
export class DasboardModule { }
