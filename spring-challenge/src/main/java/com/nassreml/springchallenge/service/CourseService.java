package com.nassreml.springchallenge.service;

import com.nassreml.springchallenge.repository.CourseRepository;
import com.nassreml.springchallenge.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public int addCourse(Course course) {
        return courseRepository.insertCourse(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.selectAllCourses();
    }
}
