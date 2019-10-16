import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FilterComponent } from './filter/filter.component';
import { TabelaComponent } from './tabela/tabela.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from 'src/app/shared/material/material.module';
import { PretragaComponent } from './pretraga/pretraga.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    MaterialModule,
    ReactiveFormsModule
  ],
  declarations: [
    FilterComponent,
    TabelaComponent,
    PretragaComponent
  ],
  exports: [
    FilterComponent,
    TabelaComponent,
    PretragaComponent
  ]
})
export class SharedMagacinModule { }
