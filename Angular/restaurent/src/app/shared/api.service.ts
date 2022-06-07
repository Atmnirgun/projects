import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators'
@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http:HttpClient) { }

  postRestaurent(data:any){
    return this.http.post<any>("http://localhost:8080/restaurant",data).pipe(map((res:any)=>{
      return res;
    }))
  }

  getRestaurent(){
    return this.http.get<any>("http://localhost:8080/restaurants").pipe(map((res:any)=>{
      return res;
    }))
  }

  updateRestaurent(data:any,id:number){
    return this.http.put("http://localhost:8080/restaurant/edit/"+id,data).pipe(map((res:any)=>{
      return res;
    }))
  }

  deleteRestaurent(id:number){
    return this.http.delete("http://localhost:8080/restaurant/delete/"+id).pipe(map((res)=>{
      return res;
    }))
  }

  getRoot(){
    return this.http.get("http://localhost:8080/isRooted").pipe(map((res)=>{
      console.log(res);
      return res;
    }))
  }
}
