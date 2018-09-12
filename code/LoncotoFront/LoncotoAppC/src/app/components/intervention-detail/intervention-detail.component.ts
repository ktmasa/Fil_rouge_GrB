import { Component, OnInit, Input, Output,EventEmitter } from '@angular/core';
import { InterventionRepositoryService } from '../../service/intervention-repository.service';



@Component({
  selector: 'app-intervention-detail',
  templateUrl: './intervention-detail.component.html',
  styleUrls: ['./intervention-detail.component.css']
})
export class InterventionDetailComponent implements OnInit {

  @Input () public interventionId:number;
  @Output() public editRequired : EventEmitter<number> = new EventEmitter<number>();

  constructor(private interventionRepository:InterventionRepositoryService) { 



  }

  ngOnInit() {
  }
  ngOnChanges(changes: any) {
    if(this.interventionId!=0){




    }
  
  }

}
