import { Component, OnInit } from '@angular/core';
import { InterventionRepositoryService } from '../../service/intervention-repository.service';
import { Subject, Subscription } from '../../../../node_modules/rxjs';
import { Intervention } from '../../metier/intervention';

@Component({
  selector: 'app-intervention-list',
  templateUrl: './intervention-list.component.html',
  styleUrls: ['./intervention-list.component.css']
})
export class InterventionListComponent implements OnInit {

  public interventionsSubject : Subject<Intervention[]>;
  private interventionsSouscription : Subscription;
  // pagination
  public totalItems : number;
  public currentPage : number;
  public taillePage : number;

  constructor(private interventionRepository: InterventionRepositoryService) { 
    this.interventionsSubject = new Subject<Intervention[]>();
  }

  ngOnInit() {
    this.interventionsSouscription = this.interventionRepository
                                    .getInterventionsPageAsObservable()
                                    .subscribe( p => {
                                      // je recois les nouvelles pages d'interventions
                                      // je transmet au ngFor le tableau des interventions
                                      this.interventionsSubject.next(p.content);
                                      this.totalItems = p.totalElements;
                                      this.currentPage = p.number + 1;
                                      this.taillePage = p.size;
                                    });
    this.interventionRepository.refreshList();
  }
  public pageChanged(event) {
    this.interventionRepository.setNoPage(event.page - 1);
  }

  ngOnDestroy(): void {
    this.interventionsSouscription.unsubscribe();
   }

}
