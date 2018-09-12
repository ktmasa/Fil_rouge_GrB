import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject, Subscription } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Etage } from '../metier/etage';
import { Page } from '../metier/Page';

@Injectable({
  providedIn: 'root'
})
export class EtageRepositoryService {

   /***/
   private etageSubject:BehaviorSubject<Etage>;
   /***/

  private etagesSubject: BehaviorSubject<Page<Etage>>;
  // pagination
  private noPage: number;
  private taillePage: number;

  constructor(private http: HttpClient) {

    /***/
    this.etageSubject = new BehaviorSubject<Etage>(null);
    /***/

    // on démarre avec une page vide
    this.etagesSubject = new BehaviorSubject<Page<Etage>>
      (Page.emptyPage<Etage>());
    this.noPage = 0;
    this.taillePage = 5;
  }

  public setNoPage(no: number) {
    this.noPage = no;
    this.refreshList();
  }

  public refreshList(): void {
    // requette ajax vers le serveur
    this.http.get<Page<Etage>>(
      `http://localhost:8080/etages/list?page=${this.noPage}&size=${this.taillePage}`)
      .subscribe(p => {
        this.etagesSubject.next(p);
      });
  }

  public getEtagesPageAsObservable(): Observable<Page<Etage>> {
    return this.etagesSubject.asObservable();
  }
  public findById(id: number): Observable<Etage> {
    return this.http.get<Etage>(`http://localhost:8080/etages/${id}`);
  }

  public deleteEtage(id: number): void {
    this.http.delete(`http://localhost:8080/etages/remove/${id}`)
      .subscribe(resp => {
        this.refreshList();
      });
  }

  public updateEtage(mat: Etage): void {
    this.http.put(`http://localhost:8080/etages/save/${mat.id}`,
      mat.toJson())
      .subscribe(resp => {
        this.refreshList();
      });
  }


//---------------------------------------------------------------------
public getEtageAsObservable() : Observable<Etage> {
  return this.etageSubject.asObservable();
}

}

