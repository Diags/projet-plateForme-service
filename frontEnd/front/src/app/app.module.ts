import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CatalogueService } from './catalogue.service';
import { UsersComponent } from './users/users.component';
import { ProfessionsDetailComponent } from './professions-detail/professions-detail.component';
import {Route, RouterModule, Routes} from "@angular/router";
import { CatalogueComponent } from './catalogue/catalogue.component';
import { CatalogueDetailComponent } from './catalogue-detail/catalogue-detail.component';
import { DevisFormComponent } from './devis-form/devis-form.component';
import { StarsComponent } from './stars/stars.component';
import { ContactComponent } from './contact/contact.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { CommonModule } from '@angular/common';
import { ProfessionelComponent } from './professionel/professionel.component';
import {HttpClientModule} from "@angular/common/http";
import { AProposComponent } from './a-propos/a-propos.component';
import { AcceuilComponent } from './acceuil/acceuil.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { TagInputModule } from 'ngx-chips';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { ProfessionalLoginComponent } from './professional-login/professional-login.component'; // this is needed!

@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    ProfessionsDetailComponent,
    CatalogueComponent,
    CatalogueDetailComponent,
    DevisFormComponent,
    StarsComponent,
    ContactComponent,
    ProfessionelComponent,
    AProposComponent,
    AcceuilComponent,
    InscriptionComponent,
    LoginComponent,
    RegistrationComponent,
    ProfessionalLoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
    TagInputModule,
    BrowserAnimationsModule
  ],
  providers: [CatalogueService],
  bootstrap: [AppComponent]
})
export class AppModule { }
