import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject, Subscription, empty } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Intervention } from '../metier/intervention';
import { Page } from '../metier/Page';

@Injectable({
  providedIn: 'root'
})
export class InterventionRepositoryService {

  private interventionsSubject: BehaviorSubject<Page<Intervention>>;
  private interventionsIntervenantSubject: BehaviorSubject<Page<Intervention>>;
  private nextInterventionSubject:BehaviorSubject<Intervention>;

  // pagination
  private noPage: number;
  private taillePage: number;

  constructor(private http: HttpClient) {
    // on démarre avec une page vid
    this.interventionsSubject = new BehaviorSubject<Page<Intervention>>(Page.emptyPage<Intervention>());
    this.interventionsIntervenantSubject= new BehaviorSubject<Page<Intervention>>(Page.emptyPage<Intervention>()); 
    this.nextInterventionSubject = new BehaviorSubject<Intervention>(null);
    this.noPage = 0;
    this.taillePage = 10;
  }

  public setNoPage(no: number) {
    this.noPage = no;
    this.refreshList();
  }

  public refreshList(): void {
    // requette ajax vers le serveur
    this.http.get<Page<Intervention>>(
      `http://localhost:8080/interventions/list?page=${this.noPage}&size=${this.taillePage}`)
      .subscribe(p => {
        this.interventionsSubject.next(p);
      });
  }

  public getListByIntervenant(id:number): void {
    // requette ajax vers le serveur
    this.http.get<Page<Intervention>>(
      `http://localhost:8080/interventions/intervenant/${id}?page=${this.noPage}&size=${this.taillePage}`)
      .subscribe(p => {
        this.interventionsIntervenantSubject.next(p);
      });
  }

  public getInterventionsPageAsObservable(): Observable<Page<Intervention>> {
    return this.interventionsSubject.asObservable();
  }

  public getInterventionsIntervenantPageAsObservable(): Observable<Page<Intervention>> {
    return this.interventionsIntervenantSubject.asObservable();
  }

  public getnextInterventionAsObservable():Observable<Intervention>{
    return this.nextInterventionSubject.asObservable();
  }

  public findNextIntervention(id : number): Observable<Intervention>{
    return this.http.get<Intervention>(`http://localhost:8080/interventions/intervenant/next/${id}`);
  }

  public findById(id: number): Observable<Intervention> {
    return this.http.get<Intervention>(`http://localhost:8080/interventions/${id}`);
  }

  public deleteIntervention(id: number): void {
    this.http.delete(`http://localhost:8080/interventions/remove/${id}`)
      .subscribe(resp => {
        this.refreshList();
      });
  }

  public updateIntervention(mat: Intervention): void {
    this.http.put(`http://localhost:8080/interventions/save/${mat.id}`,
      mat.toJson())
      .subscribe(resp => {
        this.refreshList();
      });
  }
}

