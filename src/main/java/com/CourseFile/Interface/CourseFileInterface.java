package com.CourseFile.Interface;

import java.util.List;


import com.CourseFile.Entity.Courses;

public interface CourseFileInterface {



	public List<Courses> getcourses();

	public Courses getcourse(long courseId);
	
	public Courses addcourse(Courses course);
	
	public Courses updateCourse(Courses course);
	
	public void deleteCourses(long parselong);

}
