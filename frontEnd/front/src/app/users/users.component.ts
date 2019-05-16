import { Component, OnInit } from '@angular/core';
import { CatalogueService } from '../catalogue.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  private users;
  constructor(private cat: CatalogueService) { }

  ngOnInit() {
   // this.getUsers();
  }
private getUsers(){
  this.cat.getAllUserbyMetier("/categories/1/users").subscribe(data => {
    this.users = data;
  },err=> {
    console.log(err);
  })
}
getCategoryById(id){
  
}
}
