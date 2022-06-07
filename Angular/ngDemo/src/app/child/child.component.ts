import { Component, OnInit, Input, Output } from '@angular/core';
import { EventEmitter } from '@angular/core';
import { UtilService } from '../util.service';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent implements OnInit {

  constructor(private utilService:UtilService) {
    this.utilService.userCount.subscribe(count=>{
      this.userCount = count;
    })
    this.utilService.adminCount.subscribe(count=>{
      this.adminCount = count;
    })
  }

  ngOnInit(): void {
  }
  @Input() boxColor;
  @Input() placeHolderText;

  @Output() inputEvent = new EventEmitter();
  userCount:number;
  adminCount:number;
  onCreateUser(inpVal){
    if(inpVal.value.length > 0){
      this.userCount = this.userCount + 1;
      this.inputEvent.emit(inpVal.value);
    }
  }
  onCreateAdmin(inpVal){
    if(inpVal.value.length > 0){
      this.adminCount = this.adminCount + 1;
      this.inputEvent.emit(inpVal.value);
    }
  }
}
