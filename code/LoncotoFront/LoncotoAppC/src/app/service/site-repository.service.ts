import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject, Subscription } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Site } from '../metier/site';
import { Page } from '../metier/Page';

@Injectable({
  providedIn: 'root'
})
export class SiteRepositoryService {

  private sitesSubject: BehaviorSubject<Page<Site>>;
  // pagination
  private noPage: number;
  private taillePage: number;

  constructor(private http: HttpClient) {
    // on démarre avec une page vide
    this.sitesSubject = new BehaviorSubject<Page<Site>>
      (Page.emptyPage<Site>());
    this.noPage = 0;
    this.taillePage = 5;
  }

  public setNoPage(no: number) {
    this.noPage = no;
    this.refreshList();
  }

  public refreshList(): void {
    // requette ajax vers le serveur
    this.http.get<Page<Site>>(
      `http://localhost:8080/sites/list?page=${this.noPage}&size=${this.taillePage}`)
      .subscribe(p => {
        this.sitesSubject.next(p);
      });
  }

  public getSitesPageAsObservable(): Observable<Page<Site>> {
    return this.sitesSubject.asObservable();
  }
  public findById(id: number): Observable<Site> {
    return this.http.get<Site>(`http://localhost:8080/sites/${id}`);
  }

  public deleteSite(id: number): void {
    this.http.delete(`http://localhost:8080/sites/remove/${id}`)
      .subscribe(resp => {
        this.refreshList();
      });
  }

  public updateSite(mat: Site): void {
    this.http.put(`http://localhost:8080/sites/save/${mat.id}`,
      mat.toJson())
      .subscribe(resp => {
        this.refreshList();
      });
  }
}

