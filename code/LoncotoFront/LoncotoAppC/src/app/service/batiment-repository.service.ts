import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject, Subscription } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Batiment } from '../metier/batiment';
import { Page } from '../metier/Page';

@Injectable({
  providedIn: 'root'
})
export class BatimentRepositoryService {

  /***/
  private batimentSubject:BehaviorSubject<Batiment>;
  /***/

  private batimentsSubject: BehaviorSubject<Page<Batiment>>;
  // pagination
  private noPage: number;
  private taillePage: number;

  constructor(private http: HttpClient) {

    /***/
    this.batimentSubject = new BehaviorSubject<Batiment>(null);
    /***/

    // on démarre avec une page vide
    this.batimentsSubject = new BehaviorSubject<Page<Batiment>>
      (Page.emptyPage<Batiment>());
    this.noPage = 0;
    this.taillePage = 5;
  }

  public setNoPage(no: number) {
    this.noPage = no;
    this.refreshList();
  }

  public refreshList(): void {
    // requette ajax vers le serveur
    this.http.get<Page<Batiment>>(
      `http://localhost:8080/batiments/list?page=${this.noPage}&size=${this.taillePage}`)
      .subscribe(p => {
        this.batimentsSubject.next(p);
      });
  }

  public getBatimentsPageAsObservable(): Observable<Page<Batiment>> {
    return this.batimentsSubject.asObservable();
  }
  public findById(id: number): Observable<Batiment> {
    return this.http.get<Batiment>(`http://localhost:8080/batiments/${id}`);
  }


  public deleteBatiment(id: number): void {
    this.http.delete(`http://localhost:8080/batiments/remove/${id}`)
      .subscribe(resp => {
        this.refreshList();
      });
  }

  public updateBatiment(mat: Batiment): void {
    this.http.put(`http://localhost:8080/batiments/save/${mat.id}`,
      mat.toJson())
      .subscribe(resp => {
        this.refreshList();
      });
  }

//---------------------------------------------------------------------
public getBatimentAsObservable() : Observable<Batiment> {
  return this.batimentSubject.asObservable();
}

}

