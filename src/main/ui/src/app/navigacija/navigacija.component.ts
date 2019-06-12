import { Component, OnInit } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { MatDialog } from '@angular/material';
import { Partner } from '../e-shop/model/dto';
import { LoginService } from '../e-shop/service/login.service';
import { DataService } from '../e-shop/service/data/data.service';
import { LogoutModalComponent } from '../shared/modal/logout-modal/logout-modal.component';

@Component({
  selector: 'app-navigacija',
  templateUrl: './navigacija.component.html',
  styleUrls: ['./navigacija.component.scss']
})
export class NavigacijaComponent implements OnInit {

  public korpaBadge = 0;
  public partner: Partner;

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches)
    );

  constructor(
    private breakpointObserver: BreakpointObserver,
    private korpaServis: DataService,
    private loginServis: LoginService,
    public dialog: MatDialog
  ) { }

  ngOnInit() {
    this.korpaServis.trenutnaKorpa.subscribe(korpa => this.korpaBadge = korpa.roba.length);
    this.loginServis.ulogovaniPartner.subscribe(partner => this.partner = partner);
  }

  otvoriDialog(): void {
    const dialogRef = this.dialog.open(LogoutModalComponent, {
      width: '400px'
    });
    dialogRef.afterClosed().subscribe(result => {
    });
  }
}
