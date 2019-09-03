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
  professionsFilter;
  private _listFilter;
  constructor( private catalogueService: CatalogueService, private routerActivated: ActivatedRoute, private router : Router) {
   // this.router.params.subscribe(params => this.artisantDetail = params.id)
  //   console.log(this.router.snapshot.paramMap.get('id'))
  }
  get listFilter() {
    return this._listFilter;
  }

  set listFilter(value) {
    this._listFilter = value;
    this.professionsFilter = this._listFilter ? this.perFormFilter(this.listFilter) : this.professions._embedded.professions;

  }
  ngOnInit() {
    let id = +this.routerActivated.snapshot.paramMap.get('id');
    this.catalogueService.getCatelogById(id).subscribe(resp => {
      this.professions = resp;
      this.idPublic =this.professions._embedded.professions[0].id;
      this.professionsFilter = this._listFilter ? this.perFormFilter(this.listFilter) : this.professions._embedded.professions;
    }, error =>{
      console.log(error);
    });
  }
  private perFormFilter(filterby: string) {
    filterby = filterby.toLocaleLowerCase();
    return this.professions._embedded.professions.filter(profession =>
      profession.name.toLocaleLowerCase().indexOf(filterby) != -1);
  };

  onRatingClicked(message:number
  ):void{
this.message = message;
  }
  }
