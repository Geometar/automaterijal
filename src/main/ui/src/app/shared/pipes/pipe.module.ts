import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DatePipe } from './DatePipe';
import { EmptyPipe } from './EmptyPipe';
import { TranslatePipe } from './PrevodilacPipe';
import { KatalogVreme } from './KatalogVreme';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [DatePipe, EmptyPipe, TranslatePipe, KatalogVreme],
  exports: [DatePipe, EmptyPipe, TranslatePipe, KatalogVreme]
})
export class PipeModule { }
