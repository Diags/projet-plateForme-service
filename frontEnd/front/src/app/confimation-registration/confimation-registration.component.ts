import {Component, OnInit} from '@angular/core';
import {CatalogueService} from "../catalogue.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-confimation-registration',
  templateUrl: './confimation-registration.component.html',
  styleUrls: ['./confimation-registration.component.css']
})
export class ConfimationRegistrationComponent implements OnInit {
  errorMessage;
  mode: number = 0;
  user;

  constructor(private catelogService: CatalogueService, private  routeActive: ActivatedRoute, private route: Router) {
  }

  ngOnInit() {
    let id = this.routeActive.snapshot.params.id;
    this.confirmRegister(id);
  }

  confirmRegister(token) {
    this.catelogService.confirmRegister(token).subscribe(resp => {
      this.user = resp;
      this.mode = 1;
   //   this.catelogService.saveToken(token);
    }, error => {
      this.errorMessage = error.error.message;
      this.mode = 0;
    })
  }
}
