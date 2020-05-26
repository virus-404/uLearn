import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NgForm } from '@angular/forms';

const AUTH_API = 'http://localhost:8080/api/auth/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login(credentials): Observable<any> {
    return this.http.post(AUTH_API + 'signin', {
      username: credentials.username,
      password: credentials.password
    }, httpOptions);
  }

  register(form: NgForm): Observable<any> {
    return this.http.post(AUTH_API + 'signup', {
      username: form.value?.username,
      email: form.value?.email,
      password: form.value?.password
    }, httpOptions);
  }
  sendToken(form:NgForm): Observable<any> {
    return this.http.post(AUTH_API + 'resetpass', {
      username: form.value?.user,
      token: form.value?.token
    }, httpOptions);
  }
}
