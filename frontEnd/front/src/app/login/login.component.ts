import {Component, OnInit} from '@angular/core';
import {CatalogueService} from "../catalogue.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user;

  constructor(private catalogueService:CatalogueService) {
  }

  ngOnInit() {
  }

  login(value) {
    this.catalogueService.login(value).subscribe(resp =>{
      this.user = resp;
      console.log("Login user",resp);
    });
    console.log(value);
  }
}
