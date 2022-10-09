import { Component, OnInit } from '@angular/core';
import { AuthService } from '../shared/services/auth.service';
import { User } from '../shared/services/user';

@Component({
  selector: 'app-verify-email',
  templateUrl: './verify-email.component.html',
  styleUrls: ['./verify-email.component.css']
})
export class VerifyEmailComponent implements OnInit {

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  getUser(): any {
    return this.authService.userData as User;
  }

  public sendVerificationEmail() {
    this.authService.sendVerificationEmail();
  }

}
