import { Component } from "@angular/core";
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'activation-email',
  templateUrl: './activation-email.component.html',
  styleUrls: ['./activation-email.component.css']
})
export class ActivationEmailComponent {
  constructor (public route: ActivatedRoute) {}
}


