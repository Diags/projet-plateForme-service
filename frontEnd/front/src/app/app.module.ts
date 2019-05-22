import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CatalogueService } from './catalogue.service';
import { UsersComponent } from './users/users.component';
import { ArtisantDetailComponent } from './artisant-detail/artisant-detail.component';
import {Route, RouterModule, Routes} from "@angular/router";
import { CatalogueComponent } from './catalogue/catalogue.component';
import { CatalogueDetailComponent } from './catalogue-detail/catalogue-detail.component';
import { DevisFormComponent } from './devis-form/devis-form.component';
import { StarsComponent } from './stars/stars.component';
@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    ArtisantDetailComponent,
    CatalogueComponent,
    CatalogueDetailComponent,
    DevisFormComponent,
    StarsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [CatalogueService],
  bootstrap: [AppComponent]
})
export class AppModule { }
