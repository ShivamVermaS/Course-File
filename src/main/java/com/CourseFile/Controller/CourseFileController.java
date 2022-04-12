package com.CourseFile.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	//get single course by Name
	@GetMapping("/course/{course}")
	public Courses getCourseName(@PathVariable String course)
	{
		return this.cfs.getcourseName(course);
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
	//-------------------

	@GetMapping("/")
	public String home() {
		return "welcome";
	}

	@GetMapping("/addemp")
	public String addEmpForm() {
		return "add_emp";
	}

	@PostMapping("/register")
	public String empRegister(@ModelAttribute Courses e, HttpSession session) {
		cfs.addEmp(e);
		session.setAttribute("msg", "Courses Added Sucessfully..");
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model m) {
		Courses e = cfs.getEMpById(id);
		m.addAttribute("emp", e);
		return "edit";
	}

	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Courses e, HttpSession session) {
		cfs.addEmp(e);
		session.setAttribute("msg", "Cours Data Update Sucessfully..");
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteEMp(@PathVariable Long id, HttpSession session) {

		cfs.deleteEMp(id);
		session.setAttribute("msg", "Cours Data Delete Sucessfully..");
		return "redirect:/";
	}

//	@GetMapping("/page/{pageno}")
//	public String findPaginated(@PathVariable int pageno, Model m) {
//
//		Page<Courses> emplist = cfs.getEMpByPaginate(pageno, 2);
//		m.addAttribute("emp", emplist);
//		m.addAttribute("currentPage", pageno);
//		m.addAttribute("totalPages", emplist.getTotalPages());
//		m.addAttribute("totalItem", emplist.getTotalElements());
//		return "index";
//	}
	
	
	
	
}
