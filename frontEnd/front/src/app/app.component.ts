import { Component, OnInit } from '@angular/core';
import { CatalogueService } from './catalogue.service';
import {ActivatedRoute, Route, Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  private categories;
  private uniqueCategories;
  constructor(private catelogService: CatalogueService, private router :  Router, private  routeActive: ActivatedRoute) {

  }

  ngOnInit(): void {
    this.getcatalogue();
  }

  getcatalogue() {
    this.catelogService.getCatalogue("/categories").subscribe(data => {
      this.categories = data;
      console.log(data);
    }, err => {
      console.log(err);
    })
  }
  getCategoryById(id) {
    this.catelogService.getCatelogById(id).subscribe(data => {
      console.log("cououuuuu ",this.routeActive.snapshot.params);
    this.router.navigateByUrl('/catalogue-details/'+id);
      this.categories = data;
      console.log("p2",data);
    }, err=> {
      console.log(err);
    })
  }
}
