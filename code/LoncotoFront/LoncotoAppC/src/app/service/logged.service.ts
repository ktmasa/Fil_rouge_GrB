import { Injectable } from '@angular/core';
import { Subject, Observable, Observer, BehaviorSubject } from '../../../node_modules/rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoggedService {
  private loggedUserID:Subject<number>;

  constructor() { 
    this.loggedUserID = new BehaviorSubject<number>(0);
  }

  public loggedUserIn(id:number) {
    console.log(id);
    this.loggedUserID.next(id);
  }

  public getUserLoggedId() : Observable<number> {
    return this.loggedUserID.asObservable();
  }
}

