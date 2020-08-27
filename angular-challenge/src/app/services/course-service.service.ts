import { Injectable } from '@angular/core';
import axios from 'axios';
import { Course } from '../model/course.interface'

@Injectable()
export class CourseServiceService {

  private serverUrl: string;

  constructor() {
    this.serverUrl = 'http://localhost:8080/api/v1/courses'
  }

  public getAllCourses(): Promise<Course[]> {
    return axios.get(this.serverUrl)
      .then(response => response.data);
  }
}
