import { Component, OnInit } from '@angular/core';
import { AuthService } from '../shared/services/auth.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  loginForm: any = {};

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  public login() {
    this.authService.signIn(this.loginForm.email, this.loginForm.password);
  }

}
