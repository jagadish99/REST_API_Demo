package com.testdev.springREST.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.testdev.springREST.entities.Course;
import com.testdev.springREST.services.CourseService;

@RestController
public class MyController {
	
	@Autowired
	private CourseService courseServiceObj;
	
	@GetMapping("/home")
	public String getHome() 
	{
		return "this is homepage";
	}
	
	// to get the courses at for GET request on url "/courses" 
	@GetMapping("/courses")
	public 	List<Course> getCourses()
	{
		return this.courseServiceObj.getCourses();
		
	}
	
	// to get the course with courseId 
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) 
	{
		return this.courseServiceObj.getCourse(Long.parseLong(courseId));
	}
	
	// to add a new course with details in request body
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseServiceObj.addCourse(course);
	}
	
	// to modify a course with course id given in path and course details in body
	@PutMapping("/courses/{courseId}")
	public Course modifyCourse(@PathVariable String courseId, @RequestBody Course course) {
		return this.courseServiceObj.modifyCourse(Long.parseLong(courseId), course);
		
	}
	
	
	//to delete a course with course id given in path
	@DeleteMapping("courses/{courseId}")
	public Course deleteCourse(@PathVariable String courseId) {
		return this.courseServiceObj.deleteCourse(Long.parseLong(courseId));
	}
	
	
	
	
	

}

