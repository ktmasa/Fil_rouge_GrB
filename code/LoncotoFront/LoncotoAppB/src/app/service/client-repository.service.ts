import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject, Subscription } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Client } from '../metier/client';
import { Page } from '../metier/Page';

@Injectable({
  providedIn: 'root'
})
export class ClientRepositoryService {
  
 
  private clientSubject:BehaviorSubject<Client>;
  private clientsSubjectList: BehaviorSubject<Client[]>;
  private clientsSubject: BehaviorSubject<Page<Client>>;
  // pagination
  private noPage: number;
  private taillePage: number;

  constructor(private http: HttpClient) {
    // on démarre avec une page vide

    this.clientSubject = new BehaviorSubject<Client>(null);
    this.clientsSubjectList = new BehaviorSubject<Client[]>([]);
    this.clientsSubject = new BehaviorSubject<Page<Client>>(Page.emptyPage<Client>());
    this.noPage = 0;
    this.taillePage = 5;
  }

  public setNoPage(no: number) {
    this.noPage = no;
    this.refreshList();
  }

  public refreshList(): void {
    // requette ajax vers le serveur
    this.http.get<Page<Client>>(
      `http://localhost:8080/clients/list?page=${this.noPage}&size=${this.taillePage}`)
      .subscribe(p => {
        this.clientsSubject.next(p);
      });
  }

  public findByEntreprise(entreprise:string) :void {
    this.http.get<Page<Client>>(
    `http://localhost:8080/clients/search/enterprise?name=${entreprise}&page=${this.noPage}&size=${this.taillePage}`)
    .subscribe(p => {
      this.clientsSubject.next(p);
    });
  }

  public findBySiret(siret:string) :void{
    this.http.get<Page<Client>>(
      `http://localhost:8080/clients/search/siret?name=${siret}&page=${this.noPage}&size=${this.taillePage}`)
      .subscribe(p => {
        this.clientsSubject.next(p);
      });
    }

    public findByMail(mail:string) : void {
      this.http.get<Client[]>(`http://localhost:8080/clients/search/mail?name=${mail}`).subscribe(p => {
        this.clientsSubjectList.next(p);
      });
    }

  public getClientsPageAsObservable(): Observable<Page<Client>> {
    return this.clientsSubject.asObservable();
  }
  public getClientAsObservable() : Observable<Client> {
    return this.clientSubject.asObservable();
  }
  public getClientsAsObservable() : Observable<Array<Client>> {
    return this.clientsSubjectList.asObservable();
  }

  public findById(id: number): Observable<Client> {
    return this.http.get<Client>(`http://localhost:8080/clients/${id}`);
  }

  public deleteClient(id: number): void {
    this.http.delete(`http://localhost:8080/clients/remove/${id}`)
      .subscribe(resp => {
        this.refreshList();
      });
  }

  public updateClient(mat: Client): void {
    this.http.put(`http://localhost:8080/clients/save/${mat.id}`,
      mat.toJson())
      .subscribe(resp => {
        this.refreshList();
      });
  }

}
