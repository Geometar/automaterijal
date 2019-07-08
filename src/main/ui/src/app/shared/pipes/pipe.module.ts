import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DatePipe } from './DatePipe';
import { EmptyPipe } from './EmptyPipe';
import { TranslatePipe } from './PrevodilacPipe';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [DatePipe, EmptyPipe, TranslatePipe],
  exports: [DatePipe, EmptyPipe, TranslatePipe]
})
export class PipeModule { }
