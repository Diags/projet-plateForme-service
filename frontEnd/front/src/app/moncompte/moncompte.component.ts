import { Component, OnInit } from '@angular/core';
import {CatalogueService} from "../catalogue.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-moncompte',
  templateUrl: './moncompte.component.html',
  styleUrls: ['./moncompte.component.css']
})
export class MoncompteComponent implements OnInit {

  constructor(private catalogueService:CatalogueService, private router: Router) { }

  ngOnInit() {
    this.catalogueService.loadToken();
  }

  updateMPD(value) {

  }

  isAdmin() {
    return this.catalogueService.isAdmin();
  }
}
