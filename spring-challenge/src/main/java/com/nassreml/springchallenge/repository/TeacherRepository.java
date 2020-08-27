package com.nassreml.springchallenge.repository;

import com.nassreml.springchallenge.model.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeacherRepository {

    @Select("SELECT * FROM teachers")
    List<Teacher> selectAllTeachers();
}
