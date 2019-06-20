import {Component, Input, OnInit} from '@angular/core';
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
  usersFilter;
   private _listFilter;
  private iscontactChecked= false;
  usersSearch;
 @Input() filter: string;

  constructor( private catalogueService: CatalogueService, private routerActivated: ActivatedRoute, private router : Router) {
   // this.router.params.subscribe(params => this.artisantDetail = params.id)
  //   console.log(this.router.snapshot.paramMap.get('id'))
  }
  get listFilter() {
    return this._listFilter;
  }

  set listFilter(value) {
    this._listFilter = value;
    this.usersFilter = this._listFilter ? this.perFormFilter(this.listFilter) : this.users._embedded.users;

  }
  ngOnInit() {
    let id = +this.routerActivated.snapshot.paramMap.get('id');
    if(id==0){
      this.usersSearch = this.catalogueService.curenteSearchUsers;
    }else {
      this.catalogueService.getProfessionelUserById(id).subscribe(resp => {
          this.users = resp;
          this.usersFilter = this._listFilter ? this.perFormFilter(this.listFilter) : this.users._embedded.users;
        }
        , error => {
          console.log(error);
        })
    }
  }
  private perFormFilter(filterby: string) {
    filterby = filterby.toLocaleLowerCase();
    return this.users._embedded.users.filter(user =>
     user.nom.toLocaleLowerCase().indexOf(filterby) != -1);
  };

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
