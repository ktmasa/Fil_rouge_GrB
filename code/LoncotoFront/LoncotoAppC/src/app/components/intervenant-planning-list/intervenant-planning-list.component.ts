import { Component, OnInit } from '@angular/core';
import { Subject, Subscription } from '../../../../node_modules/rxjs';
import { Intervention } from '../../metier/intervention';
import { InterventionRepositoryService } from '../../service/intervention-repository.service';

@Component({
  selector: 'app-intervenant-planning-list',
  templateUrl: './intervenant-planning-list.component.html',
  styleUrls: ['./intervenant-planning-list.component.css']
})
export class IntervenantPlanningListComponent implements OnInit {

  constructor(private interventionRepository : InterventionRepositoryService) { 

  }

  ngOnInit() {

  }



}
