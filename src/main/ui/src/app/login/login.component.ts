import { Component, OnInit } from '@angular/core';
import { Credentials } from '../model/credentials';
import { LoginService } from '../service/login.service';
import { takeWhile } from 'rxjs/operators';
import { Partner } from '../model/partner';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public registerForm: FormGroup;
  public submitted = false;
  public credentials: Credentials = {};
  public partner: Partner;
  public neuspesnoLogovanje = false;

  constructor(private loginServis: LoginService, private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      username: ['', [Validators.required, Validators.minLength(3)]],
      password: ['', [Validators.required, Validators.minLength(3)]]
    });
  }

  // convenience getter for easy access to form fields
  get f() { return this.registerForm.controls; }

  login() {
    this.submitted = true;
    // stop here if form is invalid
    if (this.registerForm.invalid) {
        return;
    }
    this.loginServis.ulogujSe(this.credentials);
    this.loginServis.ulogovaniPartner.subscribe(partner => this.partner = partner);
    this.neuspesnoLogovanje = this.partner.ppid == null;
  }
}
