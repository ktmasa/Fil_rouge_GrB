import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Intervention } from '../../metier/intervention';
import { Subject, Subscription, Observable } from '../../../../node_modules/rxjs';
import { InterventionRepositoryService } from '../../service/intervention-repository.service';
import { LoggedService } from '../../service/logged.service';
import {NgbDateStruct, NgbCalendar} from '@ng-bootstrap/ng-bootstrap';




@Component({
  selector: 'app-next-intervenant-intervention',
  templateUrl: './next-intervenant-intervention.component.html',
  styleUrls: ['./next-intervenant-intervention.component.css']
})
export class NextIntervenantInterventionComponent implements OnInit {

  public intervenantId:number;
  public nextIntervention:Intervention;
  public isvide:boolean;
  public currentIntervention : Observable<Intervention>;
  public currentInterventionSub :Subscription;

  @Output() public consult : EventEmitter<number> = new EventEmitter<number>();
  model: NgbDateStruct;
  date: {year: number, month: number};


  constructor(private interventionRepository : InterventionRepositoryService,private logged : LoggedService,private calendar: NgbCalendar) { 
    this.nextIntervention = new Intervention(0,new Date(2018,1,1),new Date(2018,1,1),"","","",0,0,null,null,null,null,null,null,null);
    this.isvide = false;
    
  }

  ngOnInit() {
    this.logged.getUserLoggedId().subscribe(id=>{this.intervenantId=id;});
    this.currentInterventionSub = this.interventionRepository.findNextIntervention(this.intervenantId).subscribe(data=>{
      if(data.id != 0){
        this.nextIntervention = data;
      }
      },
      error =>{console.log(error);}
     );
  }

  selectToday() {
    this.model = this.calendar.getToday();
  }

  public consultDetail(id :number){
    this.consult.emit(id);
  }

}
