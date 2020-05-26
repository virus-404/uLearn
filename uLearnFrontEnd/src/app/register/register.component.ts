import { Component } from '@angular/core';
import { AuthService } from '../_services/auth.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  form: any = {};
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';


  constructor(private authService: AuthService, private _snackBar: MatSnackBar) { }

  onSubmit(form: NgForm) {
    if(form.invalid) return;
    console.log("data");
    this.authService.register(this.form).subscribe(
      data => {
        console.log(data);
       this._snackBar.open('Your registration is successful!', 'OK! :D', {
        duration: 3000
      });
      },
      err => {
        this._snackBar.open('Sign up failed!', 'OK! :(', {
          duration: 3000
        });
      }
    );
    this._snackBar.dismiss();
    form.resetForm();
  }
}
