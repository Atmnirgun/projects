import { Component } from '@angular/core';
import { UtilService } from './util.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private utilService:UtilService) {
    this.utilService.userCount.subscribe(count=>{
      this.userCount = count;
    })
    this.utilService.adminCount.subscribe(count=>{
      this.adminCount = count;
    })
  }
  title = 'ngDemo';
  users = [];
  admins = [];
  adminCount:number;
  userCount:number;
  pushUsers(data){
    this.users.push(data)
  }

  pushAdmins(data){
    this.admins.push(data)
  }

  onRemoveUser(index){
    this.users.splice(index,1);
    this.utilService.userCount.next(this.users.length);
  }

  onRemoveAdmin(index){
    this.admins.splice(index,1);
    this.utilService.adminCount.next(this.admins.length);
  }
}
