import { Component, OnInit } from '@angular/core';
import {CatalogueService} from "../catalogue.service";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
   user;
   mode: number= 0;
   errorMessage;
  message: string;

  constructor(private catalogService:CatalogueService) { }

  ngOnInit() {
  }

  onRegister(user) {
    this.catalogService.register(user)
      .subscribe(data => {
          this.user = data;
          this.mode = 1;
          this.message = " STATUS: SEND";
        },
        err => {
          this.errorMessage = err.error.message;
          this.mode = 0;
        })
  }

}
