import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { JwPaginationModule } from 'jw-angular-pagination';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { CreateCourseComponent } from './create-course/create-course.component';
import { ListCoursesComponent } from './list-courses/list-courses.component';
import { CourseServiceService } from './services/course-service.service';
import { TeacherService } from './services/teacher.service';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    CreateCourseComponent,
    ListCoursesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    JwPaginationModule,
    ReactiveFormsModule
  ],
  providers: [CourseServiceService, TeacherService],
  bootstrap: [AppComponent]
})
export class AppModule { }
