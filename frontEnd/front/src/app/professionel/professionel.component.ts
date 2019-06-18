///<reference path="../catalogue.service.ts"/>
import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {CatalogueService} from "../catalogue.service";

@Component({
  selector: 'app-professionel',
  templateUrl: './professionel.component.html',
  styleUrls: ['./professionel.component.css']
})
export class ProfessionelComponent implements OnInit {
  public user;
  private iscontactChecked = false;
  private iscontactWhatShapChecked = false;
  private noteRating: number;
  constructor(private catalogueService: CatalogueService, private routerActivated: ActivatedRoute, private router: Router) {
    // this.router.params.subscribe(params => this.artisantDetail = params.id)
    //   console.log(this.router.snapshot.paramMap.get('id'))
  }

  ngOnInit() {
    let id = +this.routerActivated.snapshot.paramMap.get('id');
    this.catalogueService.getProfById(id).subscribe(resp => {
      console.log("montesssgg",resp)
      this.user = resp;
    }, error => {
      console.log(error);
    });
  }

  getDevis(){
    this.router.navigateByUrl('/devis')
  }
  toggleTel(){
    this.iscontactChecked = !this.iscontactChecked;
    console.log("iscontactChecked",this.iscontactChecked)
  }
  toggleWatshap(){
    this.iscontactWhatShapChecked = !this.iscontactWhatShapChecked;
    console.log("iscontactWhatShapChecked",this.iscontactWhatShapChecked)
  }
  onRatingClicked(note:number):void{
    this.noteRating = note;
    console.log(this.noteRating, "==> noteRating");
    let id = +this.routerActivated.snapshot.paramMap.get('id');
    this.catalogueService.updateNote(note,  id).subscribe(data =>{
      this.user = data;
      console.log(id, "==> id");
    });
  }
}
