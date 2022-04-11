package com.CourseFile.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
public class Courses {

	@Id
	long id ;
	String Name;


	
	String Course;
	double Fee;
	
	public Courses(long id, String name, String Course, double Fee) {
		super();
		this.id = id;
		this.Name = name;
		this.Course=Course;
		this.Fee=Fee;
	}
	
	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getCourse() {
		return Course;
	}
	public void setCourse(String course) {
		Course = course;
	}
	public double getFee() {
		return Fee;
	}
	public void setFee(double fee) {
		Fee = fee;
	}
	
		@Override
	public String toString() {
		return "Courses [id=" + id + ", name=" + Name + ", Course=" + Course
				+ ", Fee=" + Fee + "]";
	}
	
}

