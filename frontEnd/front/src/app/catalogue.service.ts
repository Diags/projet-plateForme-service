import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {JwtHelperService} from '@auth0/angular-jwt';
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class CatalogueService {
  //public host = "http://5.51.141.181:8989";
  public host = "http://localhost:8080";
  private jwtToken: string;
  //public host = "http://192.168.1.90:8989";
  roles: Array<any>;
  filter: string;
  userName: string;

  constructor(private http: HttpClient, private router: Router) {
  }

  curenteSearchUsers;

  getCatelogById(id) {
    return this.http.get(this.host + '/categories/' + id + '/professions/');
  }

  getCatalogue(url) {
    return this.http.get(this.host + url);
  }

  getProfessionelUserById(id) {
    return this.http.get(this.host + '/professions/' + id + '/users');
  }

  getProfById(id) {
    return this.http.get(this.host + '/users/' + id);
  }

  getAllUserbyProfessions(url) {
    return this.http.get(url);
  }

  getAllUsers(url) {
    return this.http.get(this.host + url);
  }

  updateNote(note, id) {
    return this.http.post(this.host + '/updatenote/', {
      note: note,
      id: id
    });
  }

  Search(formData) {
    return this.http.post(this.host + "/search", formData)
  }

  sendEmail(dataForm: any) {
    return this.http.post(this.host + "/sendemail", dataForm)
  }

  getPays(url) {
    return this.http.get(this.host + '/' + url);
  }

  getVilles(url) {
    return this.http.get(this.host + '/' + url);
  }

  addProfessional(dataForm) {
    return this.http.post(this.host + '/addprofessional', dataForm);
  }

  getLocation() {
    return
  }

  getProfessionalByVille(data) {
    return this.http.post(this.host + '/searchuserbyville', data)
  }

  sendForContactMe(value) {
    return this.http.post(this.host + "/sendemailcontacterme", value)
  }

  login(value) {
    return this.http.post(this.host + "/signin", value, {
      observe: 'response',
      headers: {'Content-Type': 'application/json'}
    })
  }

  saveToken(jwtToken: string) {
    localStorage.setItem("token", jwtToken);
    this.jwtToken = jwtToken;
    this.parsJWT();

  }

  parsJWT() {
    let jwtHelper = new JwtHelperService();
    let decodeToken = jwtHelper.decodeToken(this.jwtToken);
    this.userName = decodeToken.sub;
    this.roles = decodeToken.roles;
  }

  isAdmin() {
    return this.roles.find(p => {
      return this.isAuthentificated() &&  p == "ADMINISTRATOR"
    });
  }

  isUser() {
    return this.roles.find(p => {
      return this.isAuthentificated() &&  p == "USER"
    });
  }

  loadToken() {
    this.jwtToken = localStorage.getItem("token");
    this.parsJWT();
  }

  isAuthentificated() {
    return this.roles;
  }

  logout() {
    localStorage.removeItem("token");
    this.initParam();
    this.router.navigateByUrl("/login");
  }

  initParam() {
    this.userName = undefined;
    this.roles = undefined;
    this.jwtToken = undefined;
  }

  register(user: any) {
    return this.http.post(this.host + "/register", user);
  }

  confirmRegister(token) {
    let header = new HttpHeaders({'Content-Type': 'application/json', 'Authorization': 'Bearer ' + token});
    return this.http.post(this.host + "/confirmregister/", JSON.stringify({
      "jwtToken": token
    }), {headers: header});
  }

  sendCommentaire(commentaire) {
    return this.http.post(this.host + "/loginuser", commentaire)
  }

  getCommentaires(userId) {
    return this.http.get(this.host + "/users/" + userId + "/userCommentaires");
  }

  updateEvents(values) {
    return this.http.post(this.host + "/", values)
  }

  getEventsbyId(userId) {
    console.log("user ", userId);
    return this.http.get(this.host +"/events/"+userId);
  }

  storeUserEventsbyId(event, userId) {
    let header = new HttpHeaders({'Content-Type': 'application/json'});
    console.log("event ", event);
    return this.http.post(this.host +"/events",JSON.stringify({
      "event": event,
      "userId": userId
    }),{headers: header} );
  }
}
