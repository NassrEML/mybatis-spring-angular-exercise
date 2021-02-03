package com.nassreml.springchallenge;

import com.nassreml.springchallenge.api.CourseController;
import com.nassreml.springchallenge.api.TeacherController;
import com.nassreml.springchallenge.model.Course;
import com.nassreml.springchallenge.model.Difficulty;
import com.nassreml.springchallenge.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class SpringChallengeApplicationTests {

	@Autowired
	private CourseController courseController;

	@Autowired
	private TeacherController teacherController;


	@Test
	public void getAllTeachersOk() {

		ResponseEntity<List<Teacher>> response = this.teacherController.getAllTeachers();

		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertFalse(response.getBody().isEmpty());
	}


	@Test
	public void getAllCoursesOk() {

		ResponseEntity<List<Course>> response = this.courseController.getAllCourses();

		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertFalse(response.getBody().isEmpty());
	}



}
