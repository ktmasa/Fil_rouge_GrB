import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject, Subscription } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Famille } from '../metier/famille';
import { Page } from '../metier/Page';

@Injectable({
  providedIn: 'root'
})
export class FamilleRepositoryService {

  /***/
  private familleSubject:BehaviorSubject<Famille>;
  /***/

  private famillesSubject: BehaviorSubject<Page<Famille>>;
  // pagination
  private noPage: number;
  private taillePage: number;

  constructor(private http: HttpClient) {

    /***/
    this.familleSubject = new BehaviorSubject<Famille>(null);
    /***/

    // on démarre avec une page vide
    this.famillesSubject = new BehaviorSubject<Page<Famille>>
      (Page.emptyPage<Famille>());
    this.noPage = 0;
    this.taillePage = 5;
  }

  public setNoPage(no: number) {
    this.noPage = no;
    this.refreshList();
  }

  public refreshList(): void {
    // requette ajax vers le serveur
    this.http.get<Page<Famille>>(
      `http://localhost:8080/familles/list?page=${this.noPage}&size=${this.taillePage}`)
      .subscribe(p => {
        this.famillesSubject.next(p);
      });
  }

  public getFamillesPageAsObservable(): Observable<Page<Famille>> {
    return this.famillesSubject.asObservable();
  }
  public findById(id: number): Observable<Famille> {
    return this.http.get<Famille>(`http://localhost:8080/familles/${id}`);
  }

  public deleteFamille(id: number): void {
    this.http.delete(`http://localhost:8080/familles/remove/${id}`)
      .subscribe(resp => {
        this.refreshList();
      });
  }

  public updateFamille(mat: Famille): void {
    this.http.put(`http://localhost:8080/familles/save/${mat.id}`,
      mat.toJson())
      .subscribe(resp => {
        this.refreshList();
      });
  }

//---------------------------------------------------------------------
public getFamilleAsObservable() : Observable<Famille> {
  return this.familleSubject.asObservable();
}

}
