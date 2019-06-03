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
    const febi = this.febi();
    const shell = this.shell();
    const kolbenschmidt = this.kolbenschmidt();
    nizSlajdovi.push(febi, shell, kolbenschmidt);
    return nizSlajdovi;
  }

  febi() {
    const febi = new Brend();
    febi.urlSlikePozadina = 'assets/slike/novouponudi/mala/kompresori.png';
    return febi;
   }

   shell() {
    const shell = new Brend();
    shell.urlSlikePozadina = 'assets/slike/brendovi/pagepaper/shell.png';
      return shell;
   }

   kolbenschmidt() {
    const kolbenschmidt = new Brend();
    kolbenschmidt.urlSlikePozadina = 'assets/slike/brendovi/pagepaper/msc.png';
    return kolbenschmidt;
   }

   otvoriUpitModal() {
    this.dialog.open(UpitModalComponent, {
      width: '400px'
    });
   }
}
