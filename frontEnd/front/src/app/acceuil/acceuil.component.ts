import {AfterViewInit, Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {CatalogueService} from "../catalogue.service";
import {el} from "@angular/platform-browser/testing/src/browser_util";

@Component({
  selector: 'app-acceuil',
  templateUrl: './acceuil.component.html',
  styleUrls: ['./acceuil.component.css']
})
export class AcceuilComponent implements OnInit {
  users;
  categories;
  currenteCategorie;
  curenteSearchUsers;
  iscontactChecked = false;
  currentUser;

  constructor(private catelogService: CatalogueService, private  routeActive: ActivatedRoute, private route: Router) {
  }

  ngOnInit(): void {
    this.catelogService.curenteSearchUsers = [];
    this.getcatalogue("/categories");
    this.getUsers();
  }

  getcatalogue(url) {
    this.catelogService.getCatalogue(url).subscribe(data => {
      this.categories = data;
    }, err => {
      console.log(err);
    })
  }

  getUsers() {
    this.catelogService.getAllUsers("/allUsers").subscribe(data => {
      this.users = data;
      console.log("users ****>", data);
    }, err => {
      console.log(err);
    })
  }

  toggleTel(user) {
    this.currentUser = user;
    this.iscontactChecked = !this.iscontactChecked;
    console.log("iscontactChecked", this.iscontactChecked)
  }

  getcatalogueByAdresse(dataForm: any) {
    console.log("formData ++++==>  ", dataForm);
    this.catelogService.Search(dataForm).subscribe(data => {
      this.catelogService.curenteSearchUsers = data;
      this.route.navigateByUrl("/professions-details/" + 0);
    })
  }

  getUsersBycategories(c) {
    this.currenteCategorie = c;
    this.route.navigateByUrl('/catalogue/2/' + c.id);
  }
}
