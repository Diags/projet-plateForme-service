import { Component, OnInit } from '@angular/core';
import { CatalogueService } from '../catalogue.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-catalogue-detail',
  templateUrl: './catalogue-detail.component.html',
  styleUrls: ['./catalogue-detail.component.css']
})
export class CatalogueDetailComponent implements OnInit {
  private professions;
  private message: number;
  constructor( private catalogueService: CatalogueService, private routerActivated: ActivatedRoute, private router : Router) {
   // this.router.params.subscribe(params => this.artisantDetail = params.id)
  //   console.log(this.router.snapshot.paramMap.get('id'))
  }

  ngOnInit() {
    let id = +this.routerActivated.snapshot.paramMap.get('id');
    this.catalogueService.getCatelogById(id).subscribe(resp => {
      console.log("cat details",resp);
      this.professions = resp;
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
