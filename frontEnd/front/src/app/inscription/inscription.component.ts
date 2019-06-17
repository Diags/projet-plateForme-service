import {Component, OnInit} from '@angular/core';
import {CatalogueService} from "../catalogue.service";

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {
  categories;
  filteredCountriesMultiple:[];
  villes;
  mode = 1;
  pays;
  addUsers;


  constructor(private catelogService: CatalogueService) {
  }

  ngOnInit() {
    this.getcatalogue();
    this.getVilles("villes");
    this.getPays("pays");
    this.addProfessional("addprofessional");
    this.filteredCountriesMultiple = [];

  }

  getcatalogue() {
    this.catelogService.getCatalogue("/categories").subscribe(data => {
      this.categories = data;
      console.log("inscriptionTest ", data);
    }, err => {
      console.log(err);
    })
  }

  getPays(url) {
    this.catelogService.getPays(url).subscribe(resp => {
      console.log("les items ville --->", resp);
      this.pays = resp;
    }, error => {
      console.log(error);
    })
  }
  getVilles(url) {
    this.catelogService.getVilles(url).subscribe(resp => {
      console.log("les items ville --->", resp);
      this.villes = resp;
    }, error => {
      console.log(error);
    })
  }
  addProfessional(formData) {
    if (formData.tags) {
      formData.tags = this.filteredCountriesMultiple.map(function (value) {
        // @ts-ignore
        return   value.value;});
    }

    console.log("les forms data --->", formData);
    this.catelogService.addProfessional(formData).subscribe(resp => {
      this.addUsers = resp;
      console.log("addUsers ", this.addUsers);
      this.mode = 1;
    },error1 => {
      console.log(error1);
      this.mode = 0;
    });

  }
}
