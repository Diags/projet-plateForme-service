import { Component, OnInit } from '@angular/core';
import {CatalogueService} from "../catalogue.service";

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {
   categories;
  filteredCountriesMultiple: any[];
  items = ['Pizza', 'Pasta', 'Parmesan'];
  constructor(private catelogService : CatalogueService) {  }
  filterCountryMultiple(event) {
    let query = event.query;
    this.catelogService.getCatalogue("/categories").subscribe(data => {

      this.filteredCountriesMultiple = this.filterCountry(query, data);
    });
  }
  filterCountry(query, countries):any[] {
    //in a real application, make a request to a remote url with the query and return filtered results, for demo we filter at client side
    let filtered : any[] = [];
    for(let i = 0; i < countries.length; i++) {
      let country = countries[i];
      if(country.name.toLowerCase().indexOf(query.toLowerCase()) == 0) {
        filtered.push(country);
      }
    }
    return filtered;
  }
  ngOnInit() {
    this.getcatalogue();
    console.log(this.items)
  }
  getcatalogue() {
    this.catelogService.getCatalogue("/categories").subscribe(data => {
      this.categories = data;
      console.log(data);
    }, err => {
      console.log(err);
    })
  }
  requestAutocompleteItems()
  {
    this.catelogService.getCatalogue("/categories").subscribe(data => {
  return  data;
      console.log(data);
    }, err => {
      console.log(err);
    })
  }
  addProfessional(formData){
    console.log("les forms data --->",formData)
  }
}
