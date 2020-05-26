import { Component } from "@angular/core";
import { NgForm } from '@angular/forms';
import { AuthService } from '../_services/auth.service';
@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css']
})
export class ResetPasswordComponent {

  constructor(private tokenService: AuthService) {}

  onSubmit(form: NgForm){
    if(form.invalid) return;
    this.tokenService.sendToken(form);
  }
}
