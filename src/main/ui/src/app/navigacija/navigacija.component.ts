import { Component, OnInit, HostListener } from '@angular/core';
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
  public partnerUlogovan = false;
  public openSideNav = false;

  constructor(
    private korpaServis: DataService,
    private loginServis: LoginService,
    public dialog: MatDialog
  ) { }

  ngOnInit() {
    this.openSideNav = window.innerWidth < 1050;
    this.loginServis.ulogovaniPartner.subscribe(partner => this.partner = partner);
    this.loginServis.daLiJePartnerUlogovan.subscribe(bool => this.partnerUlogovan = bool);
    this.korpaServis.trenutnaKorpa.subscribe(korpa => this.korpaBadge = korpa.roba.length);
  }

  @HostListener('window:resize', ['$event'])
  onResize(event) {
    this.openSideNav = window.innerWidth < 1050;
  }

  otvoriDialog(): void {
    const dialogRef = this.dialog.open(LogoutModalComponent, {
      width: '400px'
    });
    dialogRef.afterClosed().subscribe(() => {
    });
  }
}
