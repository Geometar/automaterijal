import { Component, OnInit } from '@angular/core';
import { Brend } from '../model/dto';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material';
import { UpitModalComponent } from 'src/app/shared/modal/upit-modal/upit-modal.component';

@Component({
  selector: 'app-dasboard',
  templateUrl: './dasboard.component.html',
  styleUrls: ['./dasboard.component.scss']
})
export class DasboardComponent implements OnInit {
  public mySlidePagePapers = this.vratiSveSlajdove();

  ngOnInit() {}
  constructor(private router: Router, public dialog: MatDialog) {}

  goToShoping() {
    this.router.navigateByUrl('/roba');
  }

  vratiSveSlajdove() {
    const nizSlajdovi = [];
    const slide1 = this.slide1();
    const slide2 = this.slide2();
    const slide3 = this.slide3();
    nizSlajdovi.push(slide1, slide2, slide3);
    return nizSlajdovi;
  }

  slide1() {
    const slide = new Brend();
    slide.urlSlikePozadina = 'assets/slike/ui/slider/111.png';
    return slide;
   }

   slide2() {
    const slide = new Brend();
    slide.urlSlikePozadina = 'assets/slike/ui/slider/HEADER2.png';
    return slide;
   }

   slide3() {
    const slide = new Brend();
    slide.urlSlikePozadina = 'assets/slike/ui/slider/HEADER3.png';
    return slide;
   }

   otvoriUpitModal() {
    this.dialog.open(UpitModalComponent, {
      width: '400px'
    });
   }
}
