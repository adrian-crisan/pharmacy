import { Component, OnInit } from '@angular/core';
import { AuthService } from '../shared/services/auth.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  email: string = '';

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  public resetPassword() {
    this.authService.forgotPassword(this.email);
  }

}
