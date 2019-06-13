import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/e-shop/service/login.service';

@Component({
  selector: 'app-logout-modal',
  templateUrl: './logout-modal.component.html',
  styleUrls: ['./logout-modal.component.scss']
})
export class LogoutModalComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<LogoutModalComponent>,
    private router: Router,
    private loginServis: LoginService) {}

  ngOnInit() {
    this.loginServis.vratiUlogovanogKorisnika(false).subscribe(partner => {
      if (partner === null) {
        this.dialogRef.close();
        this.router.navigateByUrl('naslovna');
        this.loginServis.izbaciPartnerIzSesije();
      }
    });
  }

  logout() {
    this.loginServis.logout();
    this.router.navigateByUrl('naslovna');
    this.dialogRef.close();
  }

  ostaniUlogovan() {
    this.dialogRef.close();
  }
}
