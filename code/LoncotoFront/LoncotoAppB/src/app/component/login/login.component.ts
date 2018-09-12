import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Client } from '../../metier/client';
import { Intervenant } from '../../metier/intervenant';
import { ClientRepositoryService } from '../../service/client-repository.service';
import { IntervenantRepositoryService } from '../../service/intervenant-repository.service';
import { Subject, Subscription, Observable, BehaviorSubject } from 'rxjs';

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

  
  public currentIntervenant: Array<Intervenant>;
  private currentClient: Client[];

  public intervenant: Observable<Array<Intervenant>>;
  public client: Observable<Array<Client>>;

 
  public unIntervenant:Intervenant;
  public unclient:Client;

  @Output() public usertype: EventEmitter<string>;

  constructor(private clientRepository: ClientRepositoryService, private intervenantRepository: IntervenantRepositoryService) {
    this.usertype = new EventEmitter();

  }

  ngOnInit() {
    this.currentPassword = "";
    this.currentIdentifiant = "";
    this.currentClient = [];
    this.currentIntervenant = [];
    this.errMessage = "";
    this.unclient = new Client(-1,"",0,"","");
    this.unIntervenant = new Intervenant(-1,"","",0,"","",0);

  }
  public static fromJson(json: Object): Client {
    return new Client(
        json['id'],
        json['entreprise'],
        json['telephone'],
        json['mail'],
        json['siret']
    );
}
  public submitLogin() {

    this.intervenant = this.intervenantRepository.getIntervenantsAsObservable();
    this.client = this.clientRepository.getClientsAsObservable();

    this.errMessage = "";
    console.log("pass = (" + this.currentPassword + ") and log = (" + this.currentIdentifiant + ")");

    if (this.currentIdentifiant == "" || this.currentPassword == "") {
      this.errMessage = "Veuillez remplir tout les champs!";

    } else {

      this.intervenantRepository.findByMail(this.currentIdentifiant).subscribe(data => { for (let result of data) { console.log("intervenant")} });
      this.clientRepository.findByMail(this.currentIdentifiant);

      this.clientRepository.findById(1).subscribe(data=>{this.unclient = data});



      console.log("CONTENUE CLIENT :" + this.currentClient);
      console.log("CONTENUE INTERVENANT : " + this.currentIntervenant);

      console.log("here : "+this.unclient);
      /*
            if (this.currentClient&&this.currentClient.length != 0) {
              this.user = "client "+this.currentClient[0].id;
              this.usertype.emit(this.user);
      
            } else if (this.currentIntervenant&&this.currentIntervenant.length != 0) {
              this.user = "intervenant "+this.currentIntervenant[0].id;;
              this.usertype.emit(this.user);
      
            } else if (this.currentIdentifiant == "admin" && this.currentPassword == "admin") {
              this.user = "operateur ";
              this.usertype.emit(this.user);
      
            } else {
              this.errMessage = "identifiant ou mot de passe erronée";
            }*/
    }
  }
}