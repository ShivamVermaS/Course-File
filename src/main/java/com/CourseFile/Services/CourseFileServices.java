package com.CourseFile.Services;

//import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;

//import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import java.util.Optional;
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
	
	
	//------------------------------------------

	public void addEmp(Courses e) {
		// TODO Auto-generated method stub
		coursedao.save(e);
		
	}

	public Courses getEMpById(Long id) {
		// TODO Auto-generated method stub
		
		Optional<Courses> e = coursedao.findById(id);
		if (e.isPresent()) {
			return e.get();
		}
		return null;
	}

	public void deleteEMp(Long id) {
		// TODO Auto-generated method stub
		coursedao.deleteById(id);
	}

//	public Page<Courses> getEMpByPaginate(long parselong, long size) {
//		// TODO Auto-generated method stub
//		Pageable p = PageRequest.(parselong, size);
//		return coursedao.findAll(p);
//	}



}
