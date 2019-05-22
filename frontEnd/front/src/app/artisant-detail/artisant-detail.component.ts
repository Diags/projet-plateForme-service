import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import { CatalogueService } from '../catalogue.service';
@Component({
  selector: 'app-artisant-detail',
  templateUrl: './artisant-detail.component.html',
  styleUrls: ['./artisant-detail.component.css']
})
export class ArtisantDetailComponent implements OnInit {
private artisantDetail ;
  private message: number;
  constructor( private catalogueService: CatalogueService, private routerActivated: ActivatedRoute, private router : Router) {
   // this.router.params.subscribe(params => this.artisantDetail = params.id)
  //   console.log(this.router.snapshot.paramMap.get('id'))
  }

  ngOnInit() {
    let id = +this.routerActivated.snapshot.paramMap.get('id');
    this.catalogueService.getArtisantById(id).subscribe(resp => {
      console.log(resp);
      this.artisantDetail = resp;
    }, error =>{
      console.log(error);
    })
  }

  getDevis(){
    this.router.navigateByUrl('/devis')
  }
  onRatingClicked(message:number
  ):void{
    this.message = message;
    console.log(this.message, "tessssssss");
  }

  }
