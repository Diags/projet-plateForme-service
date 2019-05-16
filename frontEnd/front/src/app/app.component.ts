import { Component, OnInit } from '@angular/core';
import { CatalogueService } from './catalogue.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  private categories;
  private uniqueCategories;
  constructor(private catelogService: CatalogueService) {

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
      this.categories = data;
      console.log("p2",data);
    }, err=> {
      console.log(err);
    })

  }

}
