import { Injectable } from '@angular/core';
import axios from 'axios';
import { Teacher } from '../model/teacher.interface'


@Injectable()
export class TeacherService {

  private serverUrl: string;

  constructor() {
    this.serverUrl = 'http://localhost:8080/api/v1/teachers'
  }

  public getAllTeachers(): Promise<Teacher[]> {
    return axios.get(this.serverUrl)
      .then(response => response.data);
  }
}
