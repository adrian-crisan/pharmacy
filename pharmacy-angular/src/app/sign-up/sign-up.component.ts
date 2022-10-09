import { Component, OnInit } from '@angular/core';
import { AuthService } from '../shared/services/auth.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  signupForm: any = {};

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  public signUp() {
    this.authService.signUp(this.signupForm.email, this.signupForm.password);
  }

}
