import { Component, OnInit } from '@angular/core';
import { CatalogueService } from '../catalogue.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-catalogue-detail',
  templateUrl: './catalogue-detail.component.html',
  styleUrls: ['./catalogue-detail.component.css']
})
export class CatalogueDetailComponent implements OnInit {
   professions;
   message: number;
   public idPublic ;
  constructor( private catalogueService: CatalogueService, private routerActivated: ActivatedRoute, private router : Router) {
   // this.router.params.subscribe(params => this.artisantDetail = params.id)
  //   console.log(this.router.snapshot.paramMap.get('id'))
  }

  ngOnInit() {
    let id = +this.routerActivated.snapshot.paramMap.get('id');
    this.catalogueService.getCatelogById(id).subscribe(resp => {

      this.professions = resp;
      this.idPublic =this.professions._embedded.professions[0].id;
      console.log("cat professions",this.professions);
      console.log("this is a ",this.idPublic)
    }, error =>{
      console.log(error);
    });
  }
  onRatingClicked(message:number
  ):void{
this.message = message;
console.log(this.message, "tessssssss");
  }
  }
