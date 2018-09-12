import { Component, OnInit, OnDestroy } from '@angular/core';
import { Observable,Subject, Subscription} from "rxjs";
import { Materiel } from '../../metier/materiel';
import { MaterielRepositoryService } from '../../service/materiel-repository.service';
import { Page } from '../../metier/Page';

@Component({
  selector: 'app-client-materiel-list',
  templateUrl: './client-materiel-list.component.html',
  styleUrls: ['./client-materiel-list.component.css']
})
export class ClientMaterielListComponent implements OnInit, OnDestroy {

  public materielsSubject : Subject<Materiel[]>;
  private materielsSouscription : Subscription;

  public materiels : Observable<Array<Materiel>>;

  public totalItems : number;
  public currentPage : number;
  public taillePage : number;

  constructor(private materielRepository: MaterielRepositoryService) {
    // pour le NgFor
    this.materielsSubject = new Subject<Materiel[]>();
  }

  ngOnInit() {
    this.materielsSouscription = this.materielRepository
                                    .getMaterielsPageAsObservable()
                                    .subscribe( p => {
                                      // je recois les nouvelles pages des mat
                                      // je transmet au ngFor le tableau des mat
                                      this.materielsSubject.next(p.content);
                                      this.totalItems = p.totalElements;
                                      this.currentPage = p.number + 1;
                                      this.taillePage = p.size;
                                    });
    this.materielRepository.refreshList();
  }

  public pageChanged(event) {
    this.materielRepository.setNoPage(event.page - 1);
  }
  ngOnDestroy(): void {
    this.materielsSouscription.unsubscribe();
   }

}
