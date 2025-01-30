package com.testdev.springREST.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.testdev.springREST.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	List<Course> courseList;

	public CourseServiceImpl() {
		courseList = new ArrayList<>();
		
		courseList.add(new Course(1, "Core Java", "This course is for core java "));
		courseList.add(new Course(2, "Python for beginners", "This course is for Python"));
		courseList.add(new Course(3, "JavaScript", "This course is for Javascript"));
	}

	@Override
	public List<Course> getCourses() {
		return courseList;
	}

	@Override
	public Course getCourse(long courseId) {
		for(Course course : courseList) {
			if(course.getId()==courseId) {
				return course;
			}
		}
		return null;
	}

	@Override
	public Course addCourse(Course course) {
		courseList.add(course);
		return course;
	}

	@Override
	public Course modifyCourse(long courseId, Course course) {
		for(Course c : courseList) {
			if(c.getId() == courseId) {
				c.setId(course.getId());
				c.setTitle(course.getTitle());
				c.setDescription(course.getDescription());
			}
		}
		return course;
	}

	@Override
	public Course deleteCourse(long courseId) {
		for(Course course : courseList) {
			if(course.getId() == courseId) {
				courseList.remove(course);
				return course;
			}
		}
		return null;
	}

}
