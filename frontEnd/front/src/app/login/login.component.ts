import {Component, OnInit} from '@angular/core';
import {CatalogueService} from "../catalogue.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user;
  mode: number = 1;
  constructor(private catalogueService:CatalogueService, private router: Router) {
  }

  ngOnInit() {
  }

  login(value) {
    console.log("Login user",value);
    this.catalogueService.login(value).subscribe(resp =>{
      let jwtToken = resp.headers.get('Authorization');
      this.user = resp;
      console.log("token login ",jwtToken);
      this.catalogueService.saveToken(jwtToken);
      this.router.navigateByUrl("/moncompte");
      console.log("Login user",resp);
      this.mode = 1;
    }, error => {
      this.mode = 0;
    });
  }
}
