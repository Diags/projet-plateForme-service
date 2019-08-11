import { Component, OnInit } from '@angular/core';
import {CatalogueService} from "../catalogue.service";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
   user;
   mode: number= 1;
   errorMessage;

  constructor(private catalogService:CatalogueService) { }

  ngOnInit() {
  }

  onRegister(user) {
console.log(user,"registration user");
    this.catalogService.register(user)
      .subscribe(data => {
          console.log("registration"+data);
          this.user = data;
          this.mode = 1;
        },
        err => {
          this.errorMessage = err.error.message;
          this.mode = 0;
        })
  }

}
