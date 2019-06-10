import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import { CatalogueService } from '../catalogue.service';
@Component({
  selector: 'app-artisant-detail',
  templateUrl: './professions-detail.component.html',
  styleUrls: ['./professions-detail.component.css']
})
export class ProfessionsDetailComponent implements OnInit {
  users ;
   message: number;
   currentUser;
  private iscontactChecked= false;
  usersSearch;

  constructor( private catalogueService: CatalogueService, private routerActivated: ActivatedRoute, private router : Router) {
   // this.router.params.subscribe(params => this.artisantDetail = params.id)
  //   console.log(this.router.snapshot.paramMap.get('id'))
  }

  ngOnInit() {
    let id = +this.routerActivated.snapshot.paramMap.get('id');
    if(id==0){
      this.usersSearch = this.catalogueService.curenteSearchUsers;
      console.log("usersss *******> ",this.catalogueService.curenteSearchUsers)
    }else {
      this.catalogueService.getProfessionelUserById(id).subscribe(resp => {
          console.log(resp);
          this.users = resp;
        }
        , error => {
          console.log(error);
        })
    }
  }

  getDevis(){
    this.router.navigateByUrl('/devis')
  }

  toggleTel(user){
    this.currentUser = user;
    console.log(user);
    this.iscontactChecked = !this.iscontactChecked;
    console.log("coool",this.iscontactChecked)
}
  }
