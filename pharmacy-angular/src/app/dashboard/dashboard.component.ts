import { Component, OnInit } from '@angular/core';
import { AuthService } from '../shared/services/auth.service';
import { UserService } from '../shared/services/user.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  public backendUser: any = {};

  constructor(public authService: AuthService, private userService: UserService) { }

  ngOnInit(): void {
    this.getBackendUsers();
  }

  getBackendUsers() {
    this.userService.getUsers().subscribe(
      data => {
        this.backendUser = data;
        console.log(data);
      }
    );
  }

}
