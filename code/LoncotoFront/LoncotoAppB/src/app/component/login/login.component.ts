import { Component, OnInit, Output,EventEmitter } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public currentPassword: string;
  public currentIdentifiant: string;
  public errMessage : string;
  public user : string;

  

  @Output() public usertype : EventEmitter<string>;

  constructor() { 
    this.usertype = new EventEmitter();
  }

  ngOnInit() {
    this.currentPassword = "";
    this.currentIdentifiant = "";
    this.errMessage ="";
  }
  public submitLogin() {

    this.errMessage = "";
    console.log("pass = ("+this.currentPassword+") and log = ("+this.currentIdentifiant+")");
















    /*
    if (this.currentIdentifiant == "" || this.currentPassword == "") {
      this.errMessage= "Veuilez remplir tout les champs!";
    } else if (this.currentIdentifiant == "client" && this.currentPassword == "passclient") {
      //send client visibility
      this.user = "client";
      this.usertype.emit(this.user);
    } else if (this.currentIdentifiant == "operateur" && this.currentPassword == "passoperateur") {
      //send operateur visibility
      this.user = "operateur";
      this.usertype.emit(this.user);
    } else if (this.currentIdentifiant == "intervenant" && this.currentPassword == "passintervenant") {
      //send intervenant visibility
      this.user = "intervenant";
      this.usertype.emit(this.user);
    } else {
      this.errMessage = "identifiant ou mot de passe erronée";
    }*/
  }
}
