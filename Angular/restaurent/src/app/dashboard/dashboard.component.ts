import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms'
import { RestaurentData } from '../shared/restaurent.model';
import { ApiService } from '../shared/api.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  formValue:FormGroup;  
  restaurent : RestaurentData = new RestaurentData;
  allRestaurent:any = [];
  constructor(private formBuilder:FormBuilder, private apiService:ApiService) { }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      name:[''],
      email:[''],
      mobile:[''],
      address:[''],
      services:['']
    })
    this.getAllRestaurent();
    
  }

  addRestaurent(){
    this.restaurent.name = this.formValue.value.name;
    this.restaurent.email = this.formValue.value.email;
    this.restaurent.mobile = this.formValue.value.mobile;
    this.restaurent.address = this.formValue.value.address;
    this.restaurent.services = this.formValue.value.services;
    this.apiService.postRestaurent(this.restaurent).subscribe(res=>{
      console.log(res);
      this.formValue.reset();
      this.getAllRestaurent();
    })
  }

  getAllRestaurent(){
    this.apiService.getRestaurent().subscribe(res=>{
      this.allRestaurent = res;
    })
  }

  deleteRestaurent(data:any){
    this.apiService.deleteRestaurent(data.id).subscribe(res=>{
      alert("restaurent deleted");
      this.getAllRestaurent();
    })
  }

  onEditRestaurent(data:any){
    this.restaurent.id = data.id;
    this.formValue.controls['name'].setValue(data.name);
    this.formValue.controls['email'].setValue(data.email);
    this.formValue.controls['mobile'].setValue(data.mobile);
    this.formValue.controls['address'].setValue(data.address);
    this.formValue.controls['services'].setValue(data.services);
  }

  updateRestaurent(){
    this.restaurent.name = this.formValue.value.name;
    this.restaurent.email = this.formValue.value.email;
    this.restaurent.mobile = this.formValue.value.mobile;
    this.restaurent.address = this.formValue.value.address;
    this.restaurent.services = this.formValue.value.services;

    this.apiService.updateRestaurent(this.restaurent,this.restaurent.id).subscribe(res=>{
      alert("restaurent updated")
      this.formValue.reset();
      this.getAllRestaurent();
    })
  }

  getDeviceStatus(){
    this.apiService.getRoot().subscribe(res=>{
      console.log(res);
    })
  }
}
