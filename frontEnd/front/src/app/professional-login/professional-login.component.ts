import { Component, OnInit } from '@angular/core';
import {CatalogueService} from "../catalogue.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-professional-login',
  templateUrl: './professional-login.component.html',
  styleUrls: ['./professional-login.component.css']
})
export class ProfessionalLoginComponent implements OnInit {
  user;
  mode: number = 1;
  errorMessage;
  constructor(private catalogueService:CatalogueService, private router: Router) {
  }


  ngOnInit() {
  }

  updateMPD(value) {

  }

  login(value) {
    console.log("Login user",value);
    this.catalogueService.login(value).subscribe(resp =>{
      let jwtToken = resp.headers.get('Authorization');
      this.user = resp;
      this.catalogueService.saveToken(jwtToken);
      if (this.catalogueService.isAuthentificated() && this.catalogueService.isAdmin()){
        this.router.navigateByUrl("/moncompte");
        this.mode = 1;
      }
    }, error => {
      this.mode = 0;
      this.errorMessage = error.error.message;
    });
  }
}
