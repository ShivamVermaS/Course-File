package com.CourseFile.Services;

//import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CourseFile.Dao.CoursesDao;
import com.CourseFile.Entity.Courses;
import com.CourseFile.Interface.CourseFileInterface;


@Service
public class CourseFileServices implements CourseFileInterface {

	
	@Autowired
	 CoursesDao coursedao;

	public CourseFileServices() {
		
	}

	@Override
	public List<Courses> getcourses() {
		
		return coursedao.findAll();
	}

	@Override
	public Courses getcourse(long courseId) {
		
		return coursedao.getOne(courseId);
	}
	
//	@Override
//	public Courses getcourseName(String course) {
//		
//		return coursedao.getOne(course);
//	}

	@Override
	public Courses addcourse(Courses course) {
		coursedao.save(course);
		return course;
	}

	@Override
	public Courses updateCourse(Courses course) {

		coursedao.save(course);
		return course;
	}

	@Override
	public void deleteCourses(long parselong) {
		Courses entity=coursedao.getOne(parselong);
		coursedao.delete(entity);
	}

	@Override
	public Courses getcourseName(String course) {
		// TODO Auto-generated method stub
		return null;
	}













}
