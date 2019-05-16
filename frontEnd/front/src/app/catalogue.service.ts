import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CatalogueService {
public host = "http://localhost:8080";
  constructor(private http: HttpClient) { }

  getArtisants(url){
  return this.http.get(this.host+url);
}
getCatelogById(id){
  return this.http.get(this.host+'/categories/'+id+'/users/');
}
getCatalogue(url){
  return this.http.get(this.host+url);
}
getArtisantById(id){
  return this.http.get(this.host+'/users/'+id);
}
getAllUserbyMetier(url){
  return this.http.get(url);
}
}
