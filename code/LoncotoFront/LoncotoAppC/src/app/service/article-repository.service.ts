import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject, Subscription } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Article } from '../metier/article';
import { Page } from '../metier/Page';

@Injectable({
  providedIn: 'root'
})
export class ArticleRepositoryService {

  /***/
  private articleSubject:BehaviorSubject<Article>;
  /***/

  private articlesSubject: BehaviorSubject<Page<Article>>;
  // pagination
  private noPage: number;
  private taillePage: number;

  constructor(private http: HttpClient) {
    /***/
    this.articleSubject = new BehaviorSubject<Article>(null);
    /***/

    // on démarre avec une page vide
    this.articlesSubject = new BehaviorSubject<Page<Article>>
      (Page.emptyPage<Article>());
    this.noPage = 0;
    this.taillePage = 5;
  }

  public setNoPage(no: number) {
    this.noPage = no;
    this.refreshList();
  }

  public refreshList(): void {
    // requette ajax vers le serveur
    this.http.get<Page<Article>>(
      `http://localhost:8080/articles/list?page=${this.noPage}&size=${this.taillePage}`)
      .subscribe(p => {
        this.articlesSubject.next(p);
      });
  }

  public getArticlesPageAsObservable(): Observable<Page<Article>> {
    return this.articlesSubject.asObservable();
  }
  public findById(id: number): Observable<Article> {
    return this.http.get<Article>(`http://localhost:8080/articles/${id}`);
  }

  public deleteArticle(id: number): void {
    this.http.delete(`http://localhost:8080/articles/remove/${id}`)
      .subscribe(resp => {
        this.refreshList();
      });
  }

  public updateArticle(mat: Article): void {
    this.http.put(`http://localhost:8080/articles/save/${mat.id}`,
      mat.toJson())
      .subscribe(resp => {
        this.refreshList();
      });
  }

//---------------------------------------------------------------------
public getarticleAsObservable() : Observable<Article> {
  return this.articleSubject.asObservable();
}

}

