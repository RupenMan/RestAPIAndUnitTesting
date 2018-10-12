package edu.mum.restapi.controller;

import java.net.URI;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping("/students/{studentId}/courses")
	public ResponseEntity<Void> registerStudentForCourse(@PathVariable("studentId") String studentId, 
			@RequestBody Course newCourse){
		Course course = studentService.addCourse(studentId, newCourse);
		if(course==null) return ResponseEntity.noContent().build();
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(course.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
