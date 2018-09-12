import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject, Subscription } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Intervention } from '../metier/intervention';
import { Page } from '../metier/Page';

@Injectable({
  providedIn: 'root'
})
export class InterventionRepositoryService {

  private interventionsSubject: BehaviorSubject<Page<Intervention>>;
  // pagination
  private noPage: number;
  private taillePage: number;

  constructor(private http: HttpClient) {
    // on démarre avec une page vide
    this.interventionsSubject = new BehaviorSubject<Page<Intervention>>
      (Page.emptyPage<Intervention>());
    this.noPage = 0;
    this.taillePage = 5;
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

  public getInterventionsPageAsObservable(): Observable<Page<Intervention>> {
    return this.interventionsSubject.asObservable();
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

