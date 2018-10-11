package edu.mum.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.restapi.model.Course;
import edu.mum.restapi.service.StudentService;

@RestController
@RequestMapping(value ="/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/{studentId}/courses")
	public List<Course> retrieveCoursesOfStudent(@PathVariable ("studentId") String studentId){
		return studentService.retrieveCourses(studentId);
	}
	
	@GetMapping("/{studentId}/courses/{courseId}")
	public Course retrieveCourse(@PathVariable ("studentId") String studentId, 
			@PathVariable ("courseId") String courseId) {
		return studentService.retrieveCourse(studentId, courseId);
	}
}
