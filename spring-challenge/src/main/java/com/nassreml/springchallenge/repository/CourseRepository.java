package com.nassreml.springchallenge.repository;

import com.nassreml.springchallenge.model.Course;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseRepository {

    @Insert("INSERT INTO courses (id,availability,teacher_id,title,difficulty,hours) " +
            "VALUES (UUID(),#{availability},#{teacher_id},#{title},#{difficulty},#{hours})")
    int insertCourse(Course course);

    @Select("SELECT * FROM courses")
    List<Course> selectAllCourses();
}
