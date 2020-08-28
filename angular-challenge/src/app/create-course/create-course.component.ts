import { Component, OnInit } from '@angular/core';
import { TeacherService } from '../services/teacher.service';
import { Teacher } from '../model/teacher.interface'
import { CourseServiceService } from '../services/course-service.service';
import { Course } from '../model/course.interface'
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-create-course',
  templateUrl: './create-course.component.html',
  styleUrls: ['./create-course.component.css']
})

export class CreateCourseComponent implements OnInit {

  registerForm: FormGroup;

  submitted = false;

  course: Course;

  teachers: Teacher[];

  constructor(private teacherService: TeacherService,
    private courseService: CourseServiceService,
    private formBuilder: FormBuilder) {

    this.course = new Course();

    this.teacherService.getAllTeachers()
      .then(teachers => {
        this.teachers = teachers;
      });

  }

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      availability: [false, Validators.required],
      teacher_id: ['', Validators.required],
      title: ['', Validators.required],
      difficulty: ['', Validators.required],
      hours: [0, Validators.required],
    })
  }

  onSubmit() {
    this.submitted = true;
    if (this.registerForm.invalid) {
      return;
    }
    this.courseService.createCourse(this.course);
    window.location.href = 'http://localhost:4200/listCourses';
  }

}
