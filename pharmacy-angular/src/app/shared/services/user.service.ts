import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private userUrl: string = "http://localhost:8081/api/user";

  constructor(private http: HttpClient) { }

  getUsers(): Observable<any> {
    return this.http.get(this.userUrl, {headers: this.getHeaderWithToken()});
  }

  signUp(email: string, password: string) {
    let body = {
      email: email,
      password: password
    };
    return this.http.post(this.userUrl + '/add', body, {headers: this.getHeaderWithToken()});
  }

  getHeaderWithToken() {
    let userData = JSON.parse(localStorage.getItem('user')!);
    let token = userData.stsTokenManager.accessToken;
    const headers = {'Content-Type': 'application/json', 'Authorization': 'Bearer ' + token };
    return headers;
  }
}
