import { Component, OnInit } from '@angular/core';
import {CatalogueService} from "../catalogue.service";

@Component({
  selector: 'app-devis-form',
  templateUrl: './devis-form.component.html',
  styleUrls: ['./devis-form.component.css']
})
export class DevisFormComponent implements OnInit {
   messageStatus;
  constructor(private catelogService: CatalogueService) { }

  ngOnInit() {
  }

  sendEmailForDevis(dataForm: any) {
    console.log("formData==>  ",dataForm);
    this.catelogService.sendEmail(dataForm).subscribe(data => {
     this.messageStatus = data;
     console.log("message status",this.messageStatus)
    })
  }

}
