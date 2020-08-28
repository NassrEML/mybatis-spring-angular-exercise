import { Component, OnInit } from '@angular/core';
import { CourseServiceService } from '../services/course-service.service';
import { Course } from '../model/course.interface'

@Component({
  selector: 'app-list-courses',
  templateUrl: './list-courses.component.html',
  styleUrls: ['./list-courses.component.css']
})

export class ListCoursesComponent implements OnInit {

  pos: number;

  items: Course[] = [];

  pageOfItems: Array<Course>;

  pageSize = 2;

  public sorted: boolean = false;

  constructor(private courseService: CourseServiceService) {
    this.courseService.getAllCourses()
      .then(courses => {
        this.items = courses.filter(course => course.availability == true);
      });
  }

  ngOnInit(): void {
  }

  public sort(event) {
    this.pos = this.items.indexOf(this.pageOfItems[0]);

    if (this.sorted == false) {
      this.items.sort((c1, c2) => (c1.title < c2.title) ? 1 : -1);
      this.sorted = true;
    } else {
      this.items.sort((c1, c2) => (c1.title > c2.title) ? 1 : -1);
      this.sorted = false;
    }

    this.pageOfItems = this.items.slice(this.pos, this.pos + this.pageSize);
  }

  onChangePage(pageOfItems: Array<Course>) {
    this.pageOfItems = pageOfItems;
  }

}
