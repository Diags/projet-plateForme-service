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
  errorMessage;
  constructor(private catalogueService:CatalogueService, private router: Router) {
  }

  ngOnInit() {
  }

  login(value) {
    this.catalogueService.login(value).subscribe(resp =>{
      let jwtToken = resp.headers.get('Authorization');
      this.user = resp;
      this.catalogueService.saveToken(jwtToken);
      this.router.navigateByUrl("/moncompte");
      this.mode = 1;
    }, error => {
      this.mode = 0;
      this.errorMessage = error.error.message;
    });
  }
}
