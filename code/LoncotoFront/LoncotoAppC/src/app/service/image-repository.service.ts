import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject, Subscription } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Image } from '../metier/image';
import { Page } from '../metier/Page';

@Injectable({
  providedIn: 'root'
})
export class ImageRepositoryService {

  private imagesSubject: BehaviorSubject<Page<Image>>;
  // pagination
  private noPage: number;
  private taillePage: number;

  constructor(private http: HttpClient) {
    // on démarre avec une page vide
    this.imagesSubject = new BehaviorSubject<Page<Image>>
      (Page.emptyPage<Image>());
    this.noPage = 0;
    this.taillePage = 5;
  }

  public setNoPage(no: number) {
    this.noPage = no;
    this.refreshList();
  }

  public refreshList(): void {
    // requette ajax vers le serveur
    this.http.get<Page<Image>>(
      `http://localhost:8080/images/list?page=${this.noPage}&size=${this.taillePage}`)
      .subscribe(p => {
        this.imagesSubject.next(p);
      });
  }

  public getImagesPageAsObservable(): Observable<Page<Image>> {
    return this.imagesSubject.asObservable();
  }
  public findById(id: number): Observable<Image> {
    return this.http.get<Image>(`http://localhost:8080/images/${id}`);
  }

  public deleteImage(id: number): void {
    this.http.delete(`http://localhost:8080/images/remove/${id}`)
      .subscribe(resp => {
        this.refreshList();
      });
  }

  public updateImage(mat: Image): void {
    this.http.put(`http://localhost:8080/images/save/${mat.id}`,
      mat.toJson())
      .subscribe(resp => {
        this.refreshList();
      });
  }
}

