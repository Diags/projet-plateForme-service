import {AfterViewInit, Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import { CatalogueService } from '../catalogue.service';
import { ActivatedRoute, Router, NavigationEnd, NavigationStart } from '@angular/router';
import { Navigation } from 'selenium-webdriver';

@Component({
  selector: 'app-catalogue',
  templateUrl: './catalogue.component.html',
  styleUrls: ['./catalogue.component.css']
})
export class CatalogueComponent implements OnInit,AfterViewInit {

  constructor(private catelogService:CatalogueService, private  routeActive: ActivatedRoute, private route: Router) { }
   categories;
   currenteCategorie;
  @ViewChild('mapSen') mapSen: ElementRef;
   ngOnInit(): void {
     this.route.events.subscribe((val)=>{
if(val instanceof NavigationEnd){
  let url = val.url;
  let p1 = this.routeActive.snapshot.params.p1;
     if(p1 == 1){
         this.getcatalogue("/categories");
     }
     else if(p1 == 2){
      let id = this.routeActive.snapshot.params.p2;
      this.catelogService.getCatelogById(id).subscribe(data => {
        this.categories = data;
      }, err=> {
        console.log(err);
      })

  }

}
     });
     let p1 = this.routeActive.snapshot.params.p1;
     if(p1 == 1){
         this.getcatalogue("/categories");
     }
     this.catelogService.curenteSearchUsers=[];
   }

 getcatalogue(url){
   this.catelogService.getCatalogue(url).subscribe(data => {
     this.categories = data;
   }, err=> {
     console.log(err);
   })
 }
 getUsersBycategories(c){
   this.currenteCategorie = c;
this.route.navigateByUrl('/catalogue/2/'+c.id);
 }
  getUsersByAdresse(dataForm){
    this.catelogService.Search(dataForm).subscribe(data => {
      this.catelogService.curenteSearchUsers=data;
      this.route.navigateByUrl("/professions-details/"+0);
    })
  }


  ngAfterViewInit(): void {
    let map = this.mapSen.nativeElement.querySelector("div");
    let paths = map.querySelectorAll('svg a');
    let links = map.querySelector('#map_list').querySelectorAll('a');


    //polyfill du foreach
    if (NodeList.prototype.forEach === undefined) {
      NodeList.prototype.forEach = function (callback) {
        [].forEach.call(this.callback)
      }
    }

    paths.forEach(path => {
      path.addEventListener("mouseenter", function (e) {
        let id = this.id;
        extracted(id);
      })
    });
    links.forEach(link => {
      link.addEventListener("mouseenter", function () {
        let id = this.id.replace("list-", "");
        extracted(id);

      })
    });
    map.addEventListener("mouseover", function (e) {
      let id;
      extracted(id);

    });

    function extracted(id) {
      map.querySelectorAll('.is-active').forEach(e => {
        e.classList.remove('is-active')

      });
      if (id != undefined) {
        map.querySelector('#map_list ' + '#list-' + id).classList.add('is-active');
        map.querySelector('svg #' + id).classList.add('is-active');
      }
    }

    }

  getUsersByville (event){
  var data = {paysName:"senegal", ville:event.target.innerHTML};
    this.catelogService.curenteSearchUsers= [];
  this.catelogService.getProfessionalByVille(data).subscribe(res =>{
    this.catelogService.curenteSearchUsers=res;
    this.route.navigateByUrl("/professions-details/"+0);
    ;});
}
  onClick($event) {
     var data = {
       paysName:"senegal",
       ville:$event.target.id
     };
    this.catelogService.curenteSearchUsers= [];
    this.catelogService.getProfessionalByVille(data).subscribe(res =>{
      this.catelogService.curenteSearchUsers = res;
      this.route.navigateByUrl("/professions-details/"+0);
    });
  }
}
