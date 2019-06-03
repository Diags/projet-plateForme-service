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
    ProfessionelComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    CommonModule
  ],
  providers: [CatalogueService],
  bootstrap: [AppComponent]
})
export class AppModule { }
