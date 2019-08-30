///<reference path="../catalogue.service.ts"/>
import {Component, OnInit} from '@angular/core';
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
  currentComment;
  userCommentaires;
  sendUser;
  iscomment = false;
showAgenda:boolean = false;
  constructor(private catalogueService: CatalogueService, private routerActivated: ActivatedRoute, private router: Router) {
    // this.router.params.subscribe(params => this.artisantDetail = params.id)
    //   console.log(this.router.snapshot.paramMap.get('id'))
  }

  ngOnInit() {
    let id = +this.routerActivated.snapshot.paramMap.get('id');
    this.catalogueService.getProfById(id).subscribe(resp => {
      this.user = resp;
      this.getListComments(this.user.id);
      console.log(resp, "digs test");
    }, error => {
      console.log(error);
    });
    this.currentComment = undefined;
  }

  getDevis() {
    this.router.navigateByUrl('/devis')
  }

  toggleTel() {
    this.iscontactChecked = !this.iscontactChecked;
  }

  toggleWatshap() {
    this.iscontactWhatShapChecked = !this.iscontactWhatShapChecked;
  }

  onRatingClicked(note: number): void {
    if (this.catalogueService.isAuthentificated()) {
      this.noteRating = note;
    } else {
      alert("Authentifiez-vous avant d'envoyer un avis")
    }

  }

  sendCommtaire(dataForm, id) {
    dataForm.id = id;
    dataForm.userName = this.catalogueService.userName;
    console.log(dataForm, "tessrerere");
    this.catalogueService.sendCommentaire(dataForm).subscribe(resp => {
      this.user = resp;
      this.iscomment = true;
      let id = +this.routerActivated.snapshot.paramMap.get('id');
      this.catalogueService.updateNote(this.noteRating, id).subscribe(data => {
        this.user = data;
      }, error1 => {
        console.log(error1);
      });
    }, error => {
      this.iscomment = false;
      console.log(error);
    });
  }

  getListComments(userId) {
    this.catalogueService.getCommentaires(userId).subscribe(resp => {
    this.userCommentaires = resp;
    }, error => {
      console.log(error);
    });
  }
  isShow(){
     this.showAgenda = !this.showAgenda;
  }
}
