import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UsersComponent } from './users/users.component';
import { ProfessionsDetailGuard } from './professions-detail.guard';
import { ProfessionsDetailComponent } from './professions-detail/professions-detail.component';
import { CatalogueComponent } from './catalogue/catalogue.component';
import { AppComponent } from './app.component';
import { CatalogDetailGuard } from './catalog-detail.guard';
import { CatalogueDetailComponent } from './catalogue-detail/catalogue-detail.component';
import { DevisFormComponent } from './devis-form/devis-form.component';
import {ContactComponent} from "./contact/contact.component";
import {ProfessionelGuard} from "./professionel.guard";
import {ProfessionelComponent} from "./professionel/professionel.component";
import {AProposComponent} from "./a-propos/a-propos.component";
import {AcceuilComponent} from "./acceuil/acceuil.component";
import {InscriptionComponent} from "./inscription/inscription.component";
import {LoginComponent} from "./login/login.component";
import {RegistrationComponent} from "./registration/registration.component";
import {ProfessionalLoginComponent} from "./professional-login/professional-login.component";
import {MoncompteComponent} from "./moncompte/moncompte.component";
const routes: Routes = [
  {path:"login",component:LoginComponent},
  {path:"registration",component:RegistrationComponent},
  {path:"loginpro",component:ProfessionalLoginComponent},
  {path:"moncompte",component:MoncompteComponent},
  {path:"catalogue/:p1/:p2",component:CatalogueComponent},
  {path:"devis",component:DevisFormComponent},
  {path:"a-propos",component:AProposComponent},
  {path:"user",component:UsersComponent},
  {path:"inscription",component:InscriptionComponent},
  {path:"acceuil",component:AcceuilComponent},
  {path:"contact",component:ContactComponent},
  {path:"catalogue-details/:id",canActivate: [CatalogDetailGuard], component:CatalogueDetailComponent},
  {path:"professions",component:UsersComponent},
  {path:"professions-details/:id", canActivate: [ProfessionsDetailGuard], component: ProfessionsDetailComponent},
  {path:"professionel/:id", canActivate: [ProfessionelGuard], component: ProfessionelComponent},
  {path:"",redirectTo:'acceuil',pathMatch:'full'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
