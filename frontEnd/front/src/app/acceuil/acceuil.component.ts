import {AfterViewInit, Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {CatalogueService} from "../catalogue.service";
import {el} from "@angular/platform-browser/testing/src/browser_util";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
declare var grecaptcha: any;
@Component({
  selector: 'app-acceuil',
  templateUrl: './acceuil.component.html',
  styleUrls: ['./acceuil.component.css']
})
export class AcceuilComponent implements OnInit {
  users;
  categories;
  currenteCategorie;
  curenteSearchUsers;
  iscontactChecked = false;
  currentUser;
  messageStatus;
  mode: number= 0;
  errorMessage;
  captchaError: boolean = false;
  registerForm: FormGroup;
  constructor(private catelogService: CatalogueService, private  routeActive: ActivatedRoute, private route: Router,private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.catelogService.curenteSearchUsers = [];
    this.getcatalogue("/categories");
    this.getUsers();
    const response = grecaptcha.getResponse();
    if (response.length === 0) {
      this.captchaError = true;
      return;
    }
    this.registerForm = this.formBuilder.group({
      txtNom: ['', Validators.required],

      txtEmail: ['', [Validators.required, Validators.email]],
      txtPhone: ['', [Validators.required, Validators.minLength(8)]],
      txtMessage: ['', Validators.required],
    }, {

    });
  }

  getcatalogue(url) {
    this.catelogService.getCatalogue(url).subscribe(data => {
      this.categories = data;
    }, err => {
      console.log(err);
    })
  }

  getUsers() {
    this.catelogService.getAllUsers("/allUsers").subscribe(data => {
      this.users = data;
      console.log("users ****>", data);
    }, err => {
      console.log(err);
    })
  }

  toggleTel(user) {
    this.currentUser = user;
    this.iscontactChecked = !this.iscontactChecked;
    console.log("iscontactChecked", this.iscontactChecked)
  }

  getcatalogueByAdresse(dataForm: any) {
    console.log("formData ++++==>  ", dataForm);
    this.catelogService.Search(dataForm).subscribe(data => {
      this.catelogService.curenteSearchUsers = data;
      this.route.navigateByUrl("/professions-details/" + 0);
    })
  }

  getUsersBycategories(c) {
    this.currenteCategorie = c;
    this.route.navigateByUrl('/catalogue/2/' + c.id);
  }

  sendForContactMe(value) {
      this.catelogService.sendForContactMe(value).subscribe(data => {
        console.log("message status", data);
        this.mode = 1;
        this.route.navigateByUrl('/acceuil');
        grecaptcha.reset();
        this.ngOnInit();
      }, err => {
        this.errorMessage = err.error.message;
        this.mode = 0;
        console.log("mode ", this.mode);
      });
    }

// convenience getter for easy access to form fields
get f() { return this.registerForm.controls; }

}
