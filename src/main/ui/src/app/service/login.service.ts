import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs';
import { Credentials } from '../model/credentials';
import { map, timeout, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';

const DOMAIN_URL = 'http://localhost:8080';
const LOGIN_URL = '/login';
@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  public ulogujSe(credentials: Credentials) {
    let fullUrl = DOMAIN_URL + LOGIN_URL;
    fullUrl = fullUrl + '?' +
    'username=' + credentials.username +
    '&password=' + credentials.password +
    '&submit=' + 'Login';

    return this.http.post(fullUrl, {}).subscribe(response => {
          console.log('EVO me');
        });
  }
}
