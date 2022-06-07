import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UtilService {

  constructor() { }

  adminCount = new BehaviorSubject<number>(0);
  userCount = new BehaviorSubject<number>(0);
}
