import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, NavigationEnd, Router} from "@angular/router";
import {CatalogueService} from "../catalogue.service";

@Component({
  selector: 'app-acceuil',
  templateUrl: './acceuil.component.html',
  styleUrls: ['./acceuil.component.css']
})
export class AcceuilComponent implements OnInit {

  constructor(private catelogService:CatalogueService, private  routeActive: ActivatedRoute, private route: Router) { }
  categories;
  currenteCategorie;
  curenteSearchUsers;
  ngOnInit(): void {
    this.catelogService.curenteSearchUsers=[];
          this.getcatalogue("/categories");
  }

  getcatalogue(url){
    this.catelogService.getCatalogue(url).subscribe(data => {
      this.categories = data;
      console.log("catlogue hommm",data);
    }, err=> {
      console.log(err);
    })
  }

  getcatalogueByAdresse(dataForm: any) {
    console.log("formData ++++==>  ",dataForm);
    this.catelogService.Search(dataForm).subscribe(data => {
      this.catelogService.curenteSearchUsers=data;
      this.route.navigateByUrl("/professions-details/"+0);
    })
  }
  getUsersBycategories(c){
    this.currenteCategorie = c;
    this.route.navigateByUrl('/catalogue/2/'+c.id);
  }
}
