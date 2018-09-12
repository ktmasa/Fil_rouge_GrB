import { Component, OnInit, Input, Output,EventEmitter } from '@angular/core';
import { InterventionRepositoryService } from '../../service/intervention-repository.service';
import { Intervention } from '../../metier/intervention';



@Component({
  selector: 'app-intervention-detail',
  templateUrl: './intervention-detail.component.html',
  styleUrls: ['./intervention-detail.component.css']
})
export class InterventionDetailComponent implements OnInit {

  @Input () public interventionId:number;
  @Output() public cancel : EventEmitter<number> = new EventEmitter<number>();

  public intervention : Intervention;

  constructor(private interventionRepository:InterventionRepositoryService) { 



  }

  ngOnInit() {
  }
  public annule(){
    this.cancel.emit(0);
  }
  ngOnChanges(changes: any) {
    console.log(this.interventionId)
    if(this.interventionId!=0){
      this.interventionRepository.findById(this.interventionId).subscribe(data =>{ console.log(this.intervention);
        this.intervention = data;
      });
    }
  }

}
