package com.CourseFile.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.CourseFile.Dao.CoursesDao;
import com.CourseFile.Entity.Courses;
import com.CourseFile.Services.CourseFileServices;


@RestController
public class CourseFileController {

	@Autowired
public	CourseFileServices cfs;
//	CoursesDao coursesDao;
//	
//	 public Courses getItemById(long id) {
//	      return coursesDao.findById(id).get();
//	 }
	// get the Courses
	@GetMapping("/courses")
		public List<Courses> getCourses(){
			return this.cfs.getcourses();
	}
	
	//get single course
	@GetMapping("/courses/{courseId}")
	public Courses getCourse(@PathVariable String courseId)
	{
		return this.cfs.getcourse(Long.parseLong(courseId));
	}
	
	// course add
	@PostMapping("/courses")
	public Courses addCourses(@RequestBody Courses courses)
	{
		return this.cfs.addcourse(courses);
		
	}
	
	//update course using put request
	@PutMapping("/courses")
	public Courses updateCourses(@RequestBody Courses courses)
	{
		return this.cfs.updateCourse(courses);
		
	}
	
	//delete the course
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourses(@PathVariable String courseId){
		try {
			this.cfs.deleteCourses(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	
	
	
}
