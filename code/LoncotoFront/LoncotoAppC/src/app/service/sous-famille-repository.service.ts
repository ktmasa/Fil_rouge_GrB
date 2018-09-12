import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject, Subscription } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Sous_Famille } from '../metier/sous_famille';
import { Page } from '../metier/Page';

@Injectable({
  providedIn: 'root'
})
export class Sous_FamilleRepositoryService {

  private sous_famillesSubject: BehaviorSubject<Page<Sous_Famille>>;
  // pagination
  private noPage: number;
  private taillePage: number;

  constructor(private http: HttpClient) {
    // on démarre avec une page vide
    this.sous_famillesSubject = new BehaviorSubject<Page<Sous_Famille>>
      (Page.emptyPage<Sous_Famille>());
    this.noPage = 0;
    this.taillePage = 5;
  }

  public setNoPage(no: number) {
    this.noPage = no;
    this.refreshList();
  }

  public refreshList(): void {
    // requette ajax vers le serveur
    this.http.get<Page<Sous_Famille>>(
      `http://localhost:8080/sousfamilles/list?page=${this.noPage}&size=${this.taillePage}`)
      .subscribe(p => {
        this.sous_famillesSubject.next(p);
      });
  }

  public getSous_FamillesPageAsObservable(): Observable<Page<Sous_Famille>> {
    return this.sous_famillesSubject.asObservable();
  }
  public findById(id: number): Observable<Sous_Famille> {
    return this.http.get<Sous_Famille>(`http://localhost:8080/sousfamilles/${id}`);
  }

  public deleteSous_Famille(id: number): void {
    this.http.delete(`http://localhost:8080/sousfamilles/remove/${id}`)
      .subscribe(resp => {
        this.refreshList();
      });
  }

  public updateSous_Famille(mat: Sous_Famille): void {
    this.http.put(`http://localhost:8080/sousfamilles/save/${mat.id}`,
      mat.toJson())
      .subscribe(resp => {
        this.refreshList();
      });
  }
}