import { Component, OnInit } from '@angular/core';
import { LoginprocessService } from '../loginprocess.service';
import { DataReaderService } from '../data-reader.service';
import { Router } from '@angular/router';
import { FormGroup, FormControl } from '@angular/forms';
import { Course } from '../course';
import { HttpClient } from '@angular/common/http';

// import {NavbarComponent} from '../navbar/navbar.component'
@Component({
  selector: 'app-usermenu',
  templateUrl: './usermenu.component.html',
  styleUrls: ['./usermenu.component.css']
})
export class UsermenuComponent implements OnInit {

  currentUser
  currentUserData
  courseData
  completedUserData
  loggedin
  currentRating = 0;
  course: Course
  // public progress

  constructor(
    private loginProcess: LoginprocessService,
    // private navbar: NavbarComponent
    private dataReader: DataReaderService,
    private route: Router,
    private http: HttpClient
  ) {
    // this.dataReader.getJSON('completed-trainings.json').subscribe(data => {
    //   console.log(data);
    //   this.completedUserData = data
    // });
    // this.dataReader.getJSON('current-trainings.json').subscribe(data => {
    //   console.log(data);
    //   this.currentUserData = data
    // });
    this.dataReader.getJSON('user/courses').subscribe(data => {
      console.log(data);
      this.courseData = data
    });
  }


  ngOnInit() {
    this.currentUser = this.loginProcess.getCurrentUser();
    this.loggedin = this.loginProcess.loggedin;
    if (!this.loggedin)
      this.route.navigate(['/login']);

    // this.navbar.ngOnInit();
  }

  rate() {
    if (this.currentRating == 5)
      this.currentRating = 0
    else
      this.currentRating = this.currentRating + 1
  }

  update() {
    this.dataReader.getJSON('user/courses').subscribe(data => {
      console.log(data);
      this.courseData = data
    });
  }
  payStart(data) {
    this.course = {
      coursename: data.coursename,
      fee: data.fee,
      mentor: data.mentor,
      progress: data.progress,
      status: "Ongoing",
      user: data.user,
      id: data.id
      // edited 
    }
    this.http.post("/api/user/courses", this.course).subscribe();
    this.update();
  }
  updateProgress(data) {
    if (data.progress != 100) {
      this.course = {
        coursename: data.coursename,
        fee: data.fee,
        mentor: data.mentor,
        progress: data.progress,
        status: "Ongoing",
        user: data.user,
        id: data.id
        // edited 
      }
    }
    else {
      this.course = {
        coursename: data.coursename,
        fee: data.fee,
        mentor: data.mentor,
        progress: data.progress,
        status: "Completed",
        user: data.user,
        id: data.id
        // edited 
      }
    }
    this.http.post("/api/user/courses", this.course).subscribe();
    this.update();
  }

}
