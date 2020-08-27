import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ListCoursesComponent } from './list-courses/list-courses.component';
import { CreateCourseComponent } from './create-course/create-course.component';

const routes: Routes = [
  {
    path: 'addCourse',
    component: CreateCourseComponent
  },
  {
    path: 'listCourses',
    component: ListCoursesComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
