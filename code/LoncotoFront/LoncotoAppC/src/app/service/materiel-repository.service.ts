import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject, Subscription } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Materiel } from '../metier/materiel';
import { Page } from '../metier/Page';

@Injectable({
  providedIn: 'root'
})
export class MaterielRepositoryService {

  private materielsSubject: BehaviorSubject<Page<Materiel>>;
  // pagination
  private noPage: number;
  private taillePage: number;

  constructor(private http: HttpClient) {
    // on démarre avec une page vide
    this.materielsSubject = new BehaviorSubject<Page<Materiel>>
      (Page.emptyPage<Materiel>());
    this.noPage = 0;
    this.taillePage = 5;
  }

  public setNoPage(no: number) {
    this.noPage = no;
    this.refreshList();
  }

  public refreshList(): void {
    // requette ajax vers le serveur
    this.http.get<Page<Materiel>>(
      `http://localhost:8080/materiels/list?page=${this.noPage}&size=${this.taillePage}`)
      .subscribe(p => {
        this.materielsSubject.next(p);
      });
  }

  public getMaterielsPageAsObservable(): Observable<Page<Materiel>> {
    return this.materielsSubject.asObservable();
  }
  public findById(id: number): Observable<Materiel> {
    return this.http.get<Materiel>(`http://localhost:8080/materiels/${id}`);
  }

  public deleteMateriel(id: number): void {
    this.http.delete(`http://localhost:8080/materiels/remove/${id}`)
      .subscribe(resp => {
        this.refreshList();
      });
  }

  public updateMateriel(mat: Materiel): void {
    this.http.put(`http://localhost:8080/materiels/save/${mat.id}`,
      mat.toJson())
      .subscribe(resp => {
        this.refreshList();
      });
  }
}
