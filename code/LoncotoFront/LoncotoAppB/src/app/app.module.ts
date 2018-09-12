import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import{ Routes,RouterModule } from '@angular/router';



import { AppComponent } from './app.component';
import { LoginComponent } from './component/login/login.component';
import { UserClientComponent } from './component/user-client/user-client.component';
import { UserOperateurComponent } from './component/user-operateur/user-operateur.component';
import { UserIntervenantComponent } from './component/user-intervenant/user-intervenant.component';
import { UserIntervenantMenuComponent } from './component/user-intervenant-menu/user-intervenant-menu.component';
import { UserOperateurMenuComponent } from './component/user-operateur-menu/user-operateur-menu.component';
import { UserClientMenuComponent } from './component/user-client-menu/user-client-menu.component';
import { UserLogMenuComponent } from './component/user-log-menu/user-log-menu.component';
import { ClientMaterielListComponent } from './component/client-materiel-list/client-materiel-list.component';
import { InterventionListComponent } from './component/intervention-list/intervention-list.component';
import { InterventionDetailComponent } from './component/intervention-detail/intervention-detail.component';
import { ClientInterventionsListComponent } from './component/client-interventions-list/client-interventions-list.component';
import { ClientSitesListComponent } from './component/client-sites-list/client-sites-list.component';
import { ClientInterventionsSiteListComponent } from './component/client-interventions-site-list/client-interventions-site-list.component';
import { ClientInterventionsMaterielListComponent } from './component/client-interventions-materiel-list/client-interventions-materiel-list.component';
import { ClientMainComponent } from './component2/client-main/client-main.component';
import { IntervenenantMainComponent } from './component2/intervenenant-main/intervenenant-main.component';
import { IntervenantMainComponent } from './component2/intervenant-main/intervenant-main.component';
import { OperateurMainComponent } from './component2/operateur-main/operateur-main.component';
import { OpeClientListComponent } from './component2/ope-client-list/ope-client-list.component';
import { OpeArticleListComponent } from './component2/ope-article-list/ope-article-list.component';

import { OpeLocalisationListComponent } from './component2/ope-localisation-list/ope-localisation-list.component';
import { OpeMaterielListComponent } from './component2/ope-materiel-list/ope-materiel-list.component';
import { OpeFamilleListComponent } from './component2/ope-famille-list/ope-famille-list.component';
import { OpeIntervenantListComponent } from './component2/ope-intervenant-list/ope-intervenant-list.component';
import { OpeInterventionListComponent } from './component2/ope-intervention-list/ope-intervention-list.component';

import { OpeSousFamilleListComponent } from './component2/ope-sous-famille-list/ope-sous-famille-list.component';
import { OpeImageListComponent } from './component2/ope-image-list/ope-image-list.component';
import { ClientInterventionListComponent } from './component2/client-intervention-list/client-intervention-list.component';
import { ClientSiteListComponent } from './component2/client-site-list/client-site-list.component';
import { IntervenantPlanningListComponent } from './component2/intervenant-planning-list/intervenant-planning-list.component';
import { IntervenantInterventionListComponent } from './component2/intervenant-intervention-list/intervenant-intervention-list.component';
import { IntervenantInterventionAddComponent } from './component2/intervenant-intervention-add/intervenant-intervention-add.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    UserClientComponent,
    UserOperateurComponent,
    UserIntervenantComponent,
    UserIntervenantMenuComponent,
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
    IntervenenantMainComponent,
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
    IntervenantInterventionAddComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    /*
    RouterModule.forRoot([
      { path: 'home', component: AppComponent},
      { path: 'clientmain', component: ClientMainComponent},
      { path: 'intervenantmain', component: IntervenantMainComponent},
      { path: 'operateurmain', component: OperateurMainComponent},
      { path: '', redirectTo: '/home', pathMatch: 'full'}
    ])*/
  
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
