import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Subject, Subscription } from '../../../../node_modules/rxjs';
import { Intervention } from '../../metier/intervention';
import { InterventionRepositoryService } from '../../service/intervention-repository.service';
import { LoggedService } from '../../service/logged.service';

@Component({
  selector: 'app-intervenant-planning-list',
  templateUrl: './intervenant-planning-list.component.html',
  styleUrls: ['./intervenant-planning-list.component.css']
})
export class IntervenantPlanningListComponent implements OnInit {

  public intervention: Intervention;

public interventionSubject : Subject<Intervention[]>;
private interventionSouscription : Subscription;

private intervenantSouscription : Subscription;
public intervenantId:number

@Output() public consulteur : EventEmitter<number> = new EventEmitter<number>();

// pagination
public totalItems : number;
public currentPage : number;
public taillePage : number;

  constructor(private interventionRepository : InterventionRepositoryService,private logged:LoggedService) { 
    this.interventionSubject = new Subject<Intervention[]>();
  }

  ngOnInit() {
   this.intervenantSouscription = this.logged.getUserLoggedId().subscribe(id=>{this.intervenantId=id;});
   this.interventionSouscription = this.interventionRepository.getinterventionsIntervenantDatesubjectAsObservable().subscribe(p=>{
   this.interventionSubject.next(p.content);
   this.totalItems = p.totalElements;
   this.currentPage = p.number + 1;
   this.taillePage = p.size;
 });
 this.interventionRepository.getListByIntervenantDateOrder(this.intervenantId);
  }

  public pageChanged(event) {
    this.interventionRepository.setNoPage(event.page - 1);
   }
   
   public clickconsulter(id:number){
    this.consulteur.emit(id);
   }
   
   ngOnDestroy() {
     // unsubscribe to ensure no memory leaks
     this.intervenantSouscription.unsubscribe();
   }



}
