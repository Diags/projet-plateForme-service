import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UsersComponent } from './users/users.component';
import { ArtisantDetailGuard } from './artisant-detail.guard';
import { ArtisantDetailComponent } from './artisant-detail/artisant-detail.component';
import { CatalogueComponent } from './catalogue/catalogue.component';
import { AppComponent } from './app.component';
import { CatalogDetailGuard } from './catalog-detail.guard';
import { CatalogueDetailComponent } from './catalogue-detail/catalogue-detail.component';
import { DevisFormComponent } from './devis-form/devis-form.component';
import {ContactComponent} from "./contact/contact.component";
const routes: Routes = [
  {path:"catalogue/:p1/:p2",component:CatalogueComponent},
  {path:"devis",component:DevisFormComponent},
  {path:"contact",component:ContactComponent},
  {path:"catalogue-details/:id",canActivate: [CatalogDetailGuard], component:CatalogueDetailComponent},
  {path:"artisants",component:UsersComponent},
  {path:"artisant-details/:id", canActivate: [ArtisantDetailGuard], component: ArtisantDetailComponent},
  {path:"",redirectTo:'/catalogue/1/0',pathMatch:'full'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
