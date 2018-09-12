import { Component, OnInit, Input } from '@angular/core';
import { Intervention } from '../../metier/intervention';
import { Subject, Subscription } from '../../../../node_modules/rxjs';
import { InterventionRepositoryService } from '../../service/intervention-repository.service';
import { LoggedService } from '../../service/logged.service';

@Component({
  selector: 'app-next-intervenant-intervention',
  templateUrl: './next-intervenant-intervention.component.html',
  styleUrls: ['./next-intervenant-intervention.component.css']
})
export class NextIntervenantInterventionComponent implements OnInit {

  public intervenantId:number;
  public nextIntervention:Intervention;
  public isvide:boolean;

  constructor(private interventionRepository : InterventionRepositoryService,private logged : LoggedService) { 
    this.nextIntervention = new Intervention(0,new Date(2018,1,1),new Date(2018,1,1),"","","",0,0,null,null,null,null,null,null,null);
    this.isvide = false;
    
  }

  ngOnInit() {
    this.logged.getUserLoggedId().subscribe(id=>{this.intervenantId=id;});
    this.interventionRepository.findNextIntervention(this.intervenantId).subscribe(data=>{
      console.log("data :"+data);
      console.log("datereal"+data.dateRealisation);

      if(data===undefined||data===null){
        console.log("hey")
        this.isvide = true;
      }
      else{
        this.nextIntervention.copyFrom(data);
      }
    });
  }

}
