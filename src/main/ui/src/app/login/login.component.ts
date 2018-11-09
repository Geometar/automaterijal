import { Component, OnInit } from '@angular/core';
import { Credentials } from '../model/credentials';
import { LoginService } from '../service/login.service';
import { takeWhile } from 'rxjs/operators';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public credentials: Credentials = {};
  private alive = true;

  constructor(private loginService: LoginService) { }

  ngOnInit() {
  }

  login() {
    this.loginService.ulogujSe(this.credentials);
  }

}
