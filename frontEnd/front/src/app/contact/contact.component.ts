import { Component, OnInit } from '@angular/core';
import {CatalogueService} from "../catalogue.service";

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {
  messageStatus;
  mode: number = 0;
  errorMessage: string;
  loading = false;
  constructor(private catelogService: CatalogueService) {
  }
  ngOnInit() {
  }

  send(dataForm) {
    this.loading = true;

    this.catelogService.sendEmail(dataForm).subscribe(data => {
      this.messageStatus = data;
           this.mode = 1;
        }, err => {
      this.errorMessage = err.error.message;
      this.mode = 0;
    });
  }
}
