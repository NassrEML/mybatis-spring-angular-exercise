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
      .then(response => response.data)
      .catch(function (error) {
        if (error.response) {
          // Request made and server responded
          console.log(error.response.data);
          console.log(error.response.status);
          console.log(error.response.headers);
        } else if (error.request) {
          // The request was made but no response was received
          console.log(error.request);
        } else {
          // Something happened in setting up the request that triggered an Error
          console.log('Error', error.message);
        }

      });
  }

  public createCourse(course: Course): void {
    axios.post(this.serverUrl, course).catch(function (error) {
      if (error.response) {
        // Request made and server responded
        console.log(error.response.data);
        console.log(error.response.status);
        console.log(error.response.headers);
      } else if (error.request) {
        // The request was made but no response was received
        console.log(error.request);
      } else {
        // Something happened in setting up the request that triggered an Error
        console.log('Error', error.message);
      }

    });
  }
}
