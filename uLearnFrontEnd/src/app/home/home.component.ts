import { Component, OnInit } from '@angular/core';
import { UserService } from '../_services/user.service';
import { Note } from '../note.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  content : Note;

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.userService.getPublicContent().subscribe(
      data => {
        this.content = JSON.parse(data);

      },
      err => {
        this.content = JSON.parse(err.error).message;
      }
    );
  }
}
