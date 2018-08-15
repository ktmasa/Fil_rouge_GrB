import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
 
  title = 'LoncotoAppB';
  public isClientVisible : boolean;
  public isIntervenantVisible : boolean;
  public isOperateurVisible : boolean;
  public isLoginVisible : boolean;
  public currenttype : string;

  public constructor(){}
  
  ngOnInit(): void {
    this.isClientVisible = false;
    this.isIntervenantVisible = false;
    this.isOperateurVisible =false;
    this.isLoginVisible = true;
    this.currenttype = "login";
    
  }

  public getSubmitLogin(type :string){
    console.log("element recu!!! "+type);

    this.currenttype = type;
    console.log("current type :"+this.currenttype);
    if(this.currenttype == "client"){
      this.isLoginVisible = false;
      this.isClientVisible = true;
    }else if(this.currenttype == "operateur"){
      this.isLoginVisible = false;
      this.isOperateurVisible =true;
    }else if(this.currenttype == "intervenant"){
      this.isLoginVisible = false; 
      this.isIntervenantVisible = true;
    }else{
      this.isClientVisible = false;
      this.isIntervenantVisible = false;
      this.isOperateurVisible =false;
      this.isLoginVisible = true;
    }
  }
}
