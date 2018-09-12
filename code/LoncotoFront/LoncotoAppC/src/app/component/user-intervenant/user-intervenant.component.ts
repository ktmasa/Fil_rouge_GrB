import { Component, OnInit, Input } from '@angular/core';
import { Intervenant } from '../../metier/intervenant';
import { IntervenantRepositoryService } from '../../service/intervenant-repository.service';
import { Subscription, Subject, Observable } from '../../../../node_modules/rxjs';

@Component({
  selector: 'app-user-intervenant',
  templateUrl: './user-intervenant.component.html',
  styleUrls: ['./user-intervenant.component.css']
})
export class UserIntervenantComponent implements OnInit {

  @Input() public intervenantId : number;
  public currentIntervenant : Intervenant;
  public intervenant :Observable<Intervenant>;


  constructor(private intervenantRepository :IntervenantRepositoryService) { 
  }

  ngOnInit() {
    this.intervenant = this.intervenantRepository.getIntervenantAsObservable();
  }

  public ngOnChanges(changes : any) {
    if(this.currentIntervenant.id>0){
      this.intervenantRepository.findById(this.intervenantId).subscribe(inter =>{
        this.currentIntervenant = inter;
      });
    }
  }

}
