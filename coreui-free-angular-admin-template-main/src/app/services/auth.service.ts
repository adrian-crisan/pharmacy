import { Injectable } from '@angular/core';
import { User } from '../services/user';
import * as auth from 'firebase/auth';
import { AngularFireAuth } from '@angular/fire/compat/auth';
import { AngularFirestore, AngularFirestoreDocument } from '@angular/fire/compat/firestore';
import { Router } from '@angular/router';
import { UserService } from './user.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  userData: any;

  constructor(
    public angularFirestore: AngularFirestore,
    public angularFireAuth: AngularFireAuth,
    public router: Router,
    private userService: UserService
  ) {
    this.angularFireAuth.authState.subscribe((user) => {
      if (user) {
        this.userData = user;
        localStorage.setItem('user', JSON.stringify(this.userData));
        JSON.parse(localStorage.getItem('user')!);
      } else {
        localStorage.setItem('user', 'null');
        JSON.parse(localStorage.getItem('user')!);
      }
    });
  }

  anonymousLogin() {
    return this.angularFireAuth.signInAnonymously().then((user) => {
      this.userData = user;
    }).catch((error) => {
      window.alert(error.message);
    });
  }

  get isUserAnonymousLoggedIn(): boolean {
    console.warn(this.userData)
    return (this.userData !== null) ? this.userData.isAnonymous : false;
  }

  signIn(email: string, password: string) {
    return this.angularFireAuth.signInWithEmailAndPassword(email, password).then((result) => {
      this.router.navigate(['dashboard']);
      this.setUserData((result.user));
    }).catch((error) => {
      window.alert(error.message);
    });
  }

  signUp(email: string, password: string) {
    this.signUpOnBackend(email, password);
    return this.angularFireAuth.createUserWithEmailAndPassword(email, password).then((result) => {
      this.sendVerificationEmail();
      this.setUserData(result.user);
    }).catch((error) => {
      window.alert(error.message);
    });
  }

  signUpOnBackend(email: string, password: string) {
    return this.userService.signUp(email, password);
  }

  sendVerificationEmail() {
    return this.angularFireAuth.currentUser
      .then((user: any) => user.sendVerificationEmail())
      .then(() => {
        this.router.navigate(['verify-email-address']);
      });
  }

  forgotPassword(passwordResetEmail: string) {
    return this.angularFireAuth.sendPasswordResetEmail(passwordResetEmail).then(() => {
      window.alert('Password reset email sent.');
    }).catch((error) => {
      window.alert(error);
    });
  }

  get isLoggedIn(): boolean {
    const user = JSON.parse(localStorage.getItem('user')!);
    console.warn(user)
    return user !== null ? true : false;
  }

  setUserData(user: any) {
    const userRef: AngularFirestoreDocument<any> = this.angularFirestore.doc(
      `users/&{user.uid}`
    );
    const userData: User = {
      uid: user.uid,
      email: user.email,
      displayName:  user.displayName,
      photoURL: user.photoURL,
      emailVerified: user.emailVerified
    };
    return userRef.set(userData, { merge: true });
  }

  signOut() {
    return this.angularFireAuth.signOut().then(() => {
      localStorage.removeItem('user');
      this.router.navigate(['sign-in']);
    });
  }
}

