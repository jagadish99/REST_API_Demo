package com.testdev.springREST.services;

import java.util.List;

import com.testdev.springREST.entities.Course;

public interface CourseService {
	
	public List<Course> getCourses();

	public Course getCourse(long courseId);

	public Course addCourse(Course course);

	public Course modifyCourse(long courseId, Course course);

	public Course deleteCourse(long courseId);

}
