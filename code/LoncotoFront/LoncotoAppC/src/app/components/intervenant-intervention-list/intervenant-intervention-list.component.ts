import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Subject, Subscription, Observable } from 'rxjs';
import { Intervention } from '../../metier/intervention';
import { InterventionRepositoryService } from '../../service/intervention-repository.service';
import { LoggedService } from '../../service/logged.service';

@Component({
  selector: 'app-intervenant-intervention-list',
  templateUrl: './intervenant-intervention-list.component.html',
  styleUrls: ['./intervenant-intervention-list.component.css']
})
export class IntervenantInterventionListComponent implements OnInit {

public interventionSubject : Subject<Intervention[]>;
private interventionSouscription : Subscription;

private intervenantSouscription : Subscription;
public intervenantId:number

public consultId:number;
public isconsultVisible : boolean;

@Output() public consultInter : EventEmitter<number> = new EventEmitter<number>();

// pagination
public totalItems : number;
public currentPage : number;
public taillePage : number;


constructor(private interventionRepository : InterventionRepositoryService,private logged:LoggedService) { 
this.interventionSubject = new Subject<Intervention[]>();
}

ngOnInit() {
this.intervenantSouscription = this.logged.getUserLoggedId().subscribe(id=>{this.intervenantId=id;});
 this.interventionSouscription = this.interventionRepository.getInterventionsIntervenantPageAsObservable().subscribe(p=>{
   this.interventionSubject.next(p.content);
   this.totalItems = p.totalElements;
   this.currentPage = p.number + 1;
   this.taillePage = p.size;
 });
 this.interventionRepository.getListByIntervenant(this.intervenantId);
 this.consultId = 0;
 this.isconsultVisible = false;
}

public pageChanged(event) {
 this.interventionRepository.setNoPage(event.page - 1);
}

public clickconsulter(id:number){
  console.log("list click "+id);
 this.consultInter.emit(id);
}

ngOnDestroy() {
  // unsubscribe to ensure no memory leaks
  this.intervenantSouscription.unsubscribe();
}


}
