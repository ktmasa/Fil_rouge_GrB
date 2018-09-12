import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { PaginationModule } from "ngx-bootstrap/pagination";
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';



import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { UserClientComponent } from './component/user-client/user-client.component';
import { UserOperateurComponent } from './component/user-operateur/user-operateur.component';
import { UserIntervenantComponent } from './component/user-intervenant/user-intervenant.component';
import { UserOperateurMenuComponent } from './component/user-operateur-menu/user-operateur-menu.component';
import { UserClientMenuComponent } from './component/user-client-menu/user-client-menu.component';
import { UserLogMenuComponent } from './component/user-log-menu/user-log-menu.component';
import { ClientMaterielListComponent } from './component/client-materiel-list/client-materiel-list.component';
import { InterventionListComponent } from './component/intervention-list/intervention-list.component';
import { ClientInterventionsListComponent } from './component/client-interventions-list/client-interventions-list.component';
import { ClientSitesListComponent } from './component/client-sites-list/client-sites-list.component';
import { ClientInterventionsSiteListComponent } from './component/client-interventions-site-list/client-interventions-site-list.component';
import { ClientInterventionsMaterielListComponent } from './component/client-interventions-materiel-list/client-interventions-materiel-list.component';
import { ClientMainComponent } from './components/client-main/client-main.component';
import { IntervenantMainComponent } from './component/intervenant-main/intervenant-main.component';
import { OperateurMainComponent } from './components/operateur-main/operateur-main.component';
import { OpeClientListComponent } from './component/ope-client-list/ope-client-list.component';
import { OpeArticleListComponent } from './component/ope-article-list/ope-article-list.component';

import { OpeLocalisationListComponent } from './component/ope-localisation-list/ope-localisation-list.component';
import { OpeMaterielListComponent } from './component/ope-materiel-list/ope-materiel-list.component';
import { OpeFamilleListComponent } from './component/ope-famille-list/ope-famille-list.component';
import { OpeIntervenantListComponent } from './component/ope-intervenant-list/ope-intervenant-list.component';
import { OpeInterventionListComponent } from './component/ope-intervention-list/ope-intervention-list.component';

import { OpeSousFamilleListComponent } from './component/ope-sous-famille-list/ope-sous-famille-list.component';
import { OpeImageListComponent } from './component/ope-image-list/ope-image-list.component';
import { ClientInterventionListComponent } from './component/client-intervention-list/client-intervention-list.component';
import { ClientSiteListComponent } from './component/client-site-list/client-site-list.component';

import { InterventionDetailComponent } from './components/intervention-detail/intervention-detail.component';
import { IntervenantPlanningListComponent } from './components/intervenant-planning-list/intervenant-planning-list.component';
import { IntervenantInterventionListComponent } from './components/intervenant-intervention-list/intervenant-intervention-list.component';
import { IntervenantInterventionAddComponent } from './components/intervenant-intervention-add/intervenant-intervention-add.component';
import { NextIntervenantInterventionComponent } from './components/next-intervenant-intervention/next-intervenant-intervention.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    UserClientComponent,
    UserOperateurComponent,
    UserIntervenantComponent,
    UserOperateurMenuComponent,
    UserClientMenuComponent,
    UserLogMenuComponent,
    ClientMaterielListComponent,
    InterventionListComponent,
    InterventionDetailComponent,
    ClientInterventionsListComponent,
    ClientSitesListComponent,
    ClientInterventionsSiteListComponent,
    ClientInterventionsMaterielListComponent,
    ClientMainComponent,
    IntervenantMainComponent,
    OperateurMainComponent,
    OpeClientListComponent,
    OpeArticleListComponent,
    OpeLocalisationListComponent,
    OpeMaterielListComponent,
    OpeFamilleListComponent,
    OpeIntervenantListComponent,
    OpeInterventionListComponent,
    OpeSousFamilleListComponent,
    OpeImageListComponent,
    ClientInterventionListComponent,
    ClientSiteListComponent,
    IntervenantPlanningListComponent,
    IntervenantInterventionListComponent,
    IntervenantInterventionAddComponent,
    NextIntervenantInterventionComponent
 
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    NgbModule,
    PaginationModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
