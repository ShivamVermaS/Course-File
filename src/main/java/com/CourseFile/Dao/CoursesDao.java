package com.CourseFile.Dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.CourseFile.Entity.Courses;

@Service
public interface CoursesDao extends JpaRepository<Courses, Long>{

	



}
