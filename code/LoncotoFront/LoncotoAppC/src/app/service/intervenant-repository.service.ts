import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject, Subscription, empty } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Intervenant } from '../metier/intervenant';
import { Page } from '../metier/Page';

@Injectable({
  providedIn: 'root'
})
export class IntervenantRepositoryService {
  
  private intervenantsSubject: BehaviorSubject<Page<Intervenant>>;
  
  
  /**/
  private intervenantsSubjectList : BehaviorSubject<Array<Intervenant>>;
  private intervenantSubject :BehaviorSubject<Intervenant>;
/**/

  // pagination
  private noPage: number;
  private taillePage: number;

  constructor(private http: HttpClient) {
    // on démarre avec une page vide
    /**/
    this.intervenantSubject = new BehaviorSubject<Intervenant>(null);
    this.intervenantsSubjectList = new BehaviorSubject<Array<Intervenant>>([]);
    /**/

    
    this.intervenantsSubject = new BehaviorSubject<Page<Intervenant>>
      (Page.emptyPage<Intervenant>());
    this.noPage = 0;
    this.taillePage = 5;
  }

  public setNoPage(no: number) {
    this.noPage = no;
    this.refreshList();
  }

  public refreshList(): void {
    // requette ajax vers le serveur
    this.http.get<Page<Intervenant>>(
      `http://localhost:8080/intervenants/list?page=${this.noPage}&size=${this.taillePage}`)
      .subscribe(p => {
        this.intervenantsSubject.next(p);
      });
  }

  public getIntervenantsPageAsObservable(): Observable<Page<Intervenant>> {
    return this.intervenantsSubject.asObservable();
  }
  public findById(id: number): Observable<Intervenant> {
    return this.http.get<Intervenant>(`http://localhost:8080/intervenants/${id}`);
  }

  public findFixedDateDisponibleIntervenant(spe:string,date:Date): void {
    this.http.get<Page<Intervenant>>(
      `http://localhost:8080/intervenants/dispo?spe=${spe}&date=${date}&page=${this.noPage}&size=${this.taillePage}`)
      .subscribe(p => {
        this.intervenantsSubject.next(p);
      });
  }

  public findByMail(mail:string) : Observable<Array<Intervenant>>{
    return this.http.get<Array<Intervenant>>(`http://localhost:8080/intervenants/search/mail?name=${mail}`);
  }

  public deleteIntervenant(id: number): void {
    this.http.delete(`http://localhost:8080/intervenants/remove/${id}`)
      .subscribe(resp => {
        this.refreshList();
      });
  }

  public updateIntervenant(mat: Intervenant): void {
    this.http.put(`http://localhost:8080/intervenants/save/${mat.id}`,
      mat.toJson())
      .subscribe(resp => {
        this.refreshList();
      });
  }

//---------------------------------------------------------------------
public getIntervenantAsObservable() : Observable<Intervenant> {
  return this.intervenantSubject.asObservable();
}

public getIntervenantsAsObservable() : Observable<Array<Intervenant>> {
  return this.intervenantsSubjectList.asObservable();
}





}

