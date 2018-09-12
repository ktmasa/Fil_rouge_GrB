import { Component, OnInit, Output, EventEmitter, OnChanges } from '@angular/core';
import { Client } from '../../metier/client';
import { Intervenant } from '../../metier/intervenant';
import { ClientRepositoryService } from '../../service/client-repository.service';
import { IntervenantRepositoryService } from '../../service/intervenant-repository.service';
import { Subject, Subscription, Observable, BehaviorSubject } from 'rxjs';
import { browser } from '../../../../node_modules/protractor';
import { LoggedService } from '../../service/logged.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public currentPassword: string;
  public currentIdentifiant: string;

  public errMessage: string;
  public user: string;

  public unIntervenant: Intervenant;
  public unclient: Client;

  public isClientVisible : boolean;
  public isIntervenantVisible : boolean;
  public isOperateurVisible : boolean;
  public isLoginVisible : boolean;

  public isplanningvisible:boolean;
  public isinterventionsvisible:boolean;

  constructor(private clientRepository: ClientRepositoryService, private intervenantRepository: IntervenantRepositoryService,private loguser:LoggedService) { 
    this.isClientVisible = false;
    this.isIntervenantVisible = false;
    this.isOperateurVisible =false;
    this.isLoginVisible = true;

    this.isinterventionsvisible = false;
    this.isplanningvisible = false;
  }

  ngOnInit() {
    this.currentPassword = "";
    this.currentIdentifiant = "";
    this.errMessage = "";
    this.unclient = new Client(-1, "", 0, "", "");
    this.unIntervenant = new Intervenant(-1, "", "", 0, "", "", 0);

    this.isClientVisible = false;
    this.isIntervenantVisible = false;
    this.isOperateurVisible =false;
    this.isLoginVisible = true;
  }

  public submitLogin() {

    this.errMessage = "";
    console.log("pass = (" + this.currentPassword + ") and log = (" + this.currentIdentifiant + ")");

    if (this.currentIdentifiant == "" || this.currentPassword == "") {
      this.errMessage = "Veuillez remplir tout les champs!";

    } else {
      this.intervenantRepository.findByMail(this.currentIdentifiant).subscribe(data => { for (let result of data) { this.unIntervenant.id = result.id } });
      this.clientRepository.findByMail(this.currentIdentifiant).subscribe(data => { for (let result of data) { this.unclient.id = result.id } });

      if (this.unclient.id != -1) {
        this.loguser.loggedUserIn(this.unclient.id);
        this.isLoginVisible = false;
        this.isClientVisible = true;
      } else if (this.unIntervenant.id != -1) {
        this.loguser.loggedUserIn(this.unIntervenant.id);
        this.isLoginVisible = false; 
        this.isIntervenantVisible = true;
      } else if (this.currentIdentifiant == "admin" && this.currentPassword == "admin") {
        this.isLoginVisible = false;
        this.isOperateurVisible =true;
      } else {
        this.errMessage = "identifiant ou mot de passe erronée";
        this.isClientVisible = false;
        this.isIntervenantVisible = false;
        this.isOperateurVisible =false;
        this.isLoginVisible = true;
      }
    }
  }
  public menuPlanning(){
    this.isplanningvisible = true;
    this.isinterventionsvisible = false;
  }
   public menuIntervention(){
    this.isplanningvisible = false;
    this.isinterventionsvisible = true;
   }
}