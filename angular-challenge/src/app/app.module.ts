import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { JwPaginationModule } from 'jw-angular-pagination';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { CreateCourseComponent } from './create-course/create-course.component';
import { ListCoursesComponent } from './list-courses/list-courses.component';
import { CourseServiceService } from './services/course-service.service';

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
    JwPaginationModule
  ],
  providers: [CourseServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
