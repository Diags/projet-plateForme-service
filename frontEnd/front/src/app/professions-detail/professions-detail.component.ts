import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import { CatalogueService } from '../catalogue.service';
@Component({
  selector: 'app-artisant-detail',
  templateUrl: './professions-detail.component.html',
  styleUrls: ['./professions-detail.component.css']
})
export class ProfessionsDetailComponent implements OnInit {
 artisantDetail ;
   message: number;
  private iscontactChecked= false;
  constructor( private catalogueService: CatalogueService, private routerActivated: ActivatedRoute, private router : Router) {
   // this.router.params.subscribe(params => this.artisantDetail = params.id)
  //   console.log(this.router.snapshot.paramMap.get('id'))
  }

  ngOnInit() {
    let id = +this.routerActivated.snapshot.paramMap.get('id');
    this.catalogueService.getProfessionelUserById(id).subscribe(resp => {
      console.log(resp);
      this.artisantDetail = resp;
    }, error =>{
      console.log(error);
    })
  }

  getDevis(){
    this.router.navigateByUrl('/devis')
  }

  toggleTel(){
    this.iscontactChecked = !this.iscontactChecked;
    console.log("coool",this.iscontactChecked)
}
  }
