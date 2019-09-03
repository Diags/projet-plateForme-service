import {Component, OnInit} from '@angular/core';
import {CatalogueService} from "../catalogue.service";

@Component({
  selector: 'app-devis-form',
  templateUrl: './devis-form.component.html',
  styleUrls: ['./devis-form.component.css']
})
export class DevisFormComponent implements OnInit {
  messageStatus;
  mode: number = 0;
  errorMessage: string;
  loading = false;
  constructor(private catelogService: CatalogueService) {
  }

  ngOnInit() {
  }

  sendEmailForDevis(dataForm) {
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
