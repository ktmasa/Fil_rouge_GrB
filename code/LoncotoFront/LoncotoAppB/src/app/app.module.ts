import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import{ RouterModule } from '@angular/router';



import { AppComponent } from './app.component';
import { LoginComponent } from './component/login/login.component';
import { UserClientComponent } from './component/user-client/user-client.component';
import { UserOperateurComponent } from './component/user-operateur/user-operateur.component';
import { UserIntervenantComponent } from './component/user-intervenant/user-intervenant.component';
import { UserIntervenantMenuComponent } from './component/user-intervenant-menu/user-intervenant-menu.component';
import { UserOperateurMenuComponent } from './component/user-operateur-menu/user-operateur-menu.component';
import { UserClientMenuComponent } from './component/user-client-menu/user-client-menu.component';
import { UserLogMenuComponent } from './component/user-log-menu/user-log-menu.component';

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
    UserLogMenuComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
