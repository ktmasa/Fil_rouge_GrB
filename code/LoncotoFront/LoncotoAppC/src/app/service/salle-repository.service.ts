import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject, Subscription } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Salle } from '../metier/salle';
import { Page } from '../metier/Page';

@Injectable({
  providedIn: 'root'
})
export class SalleRepositoryService {

  private sallesSubject: BehaviorSubject<Page<Salle>>;
  // pagination
  private noPage: number;
  private taillePage: number;

  constructor(private http: HttpClient) {
    // on démarre avec une page vide
    this.sallesSubject = new BehaviorSubject<Page<Salle>>
      (Page.emptyPage<Salle>());
    this.noPage = 0;
    this.taillePage = 5;
  }

  public setNoPage(no: number) {
    this.noPage = no;
    this.refreshList();
  }

  public refreshList(): void {
    // requette ajax vers le serveur
    this.http.get<Page<Salle>>(
      `http://localhost:8080/salles/list?page=${this.noPage}&size=${this.taillePage}`)
      .subscribe(p => {
        this.sallesSubject.next(p);
      });
  }

  public getSallesPageAsObservable(): Observable<Page<Salle>> {
    return this.sallesSubject.asObservable();
  }
  public findById(id: number): Observable<Salle> {
    return this.http.get<Salle>(`http://localhost:8080/salles/${id}`);
  }

  public deleteSalle(id: number): void {
    this.http.delete(`http://localhost:8080/salles/remove/${id}`)
      .subscribe(resp => {
        this.refreshList();
      });
  }

  public updateSalle(mat: Salle): void {
    this.http.put(`http://localhost:8080/salles/save/${mat.id}`,
      mat.toJson())
      .subscribe(resp => {
        this.refreshList();
      });
  }
}
