import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import {CatalogueService} from "../catalogue.service";

@Component({
  selector: 'app-stars',
  templateUrl: './stars.component.html',
  styleUrls: ['./stars.component.css']
})
export class StarsComponent implements OnInit, OnChanges {
@ Input() rating : number;
  starWidth:number;
  userId;
  currentColor :string;
  @Output() ratingClicked: EventEmitter<String>=   new EventEmitter<String>();

  constructor(private catalogueService : CatalogueService) { }

  ngOnInit() {
  }
onClick():void{
    this.ratingClicked.emit(""+this.rating);
}
  ngOnChanges(): void {
  this.starWidth = this.rating *75/5;
  this.currentColor = 'btn-warning';
  console.log(this.rating)

  }

}
