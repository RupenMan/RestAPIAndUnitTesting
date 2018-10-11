package edu.mum.restapi.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import edu.mum.restapi.model.Course;
import edu.mum.restapi.model.Student;

@Service
public class StudentService {
	private static List<Student> students = new ArrayList<>();

	static {
		//Initialize Data
		Course course1 = new Course("Course1", "Spring", "10 Steps", Arrays
				.asList("Learn Maven", "Import Project", "First Example",
						"Second Example"));
		Course course2 = new Course("Course2", "Spring MVC", "10 Examples",
				Arrays.asList("Learn Maven", "Import Project", "First Example",
						"Second Example"));
		Course course3 = new Course("Course3", "Spring Boot", "6K Students",
				Arrays.asList("Learn Maven", "Learn Spring",
						"Learn Spring MVC", "First Example", "Second Example"));
		Course course4 = new Course("Course4", "Maven",
				"Most popular maven course on internet!", Arrays.asList(
						"Pom.xml", "Build Life Cycle", "Parent POM",
						"Importing into Eclipse"));

		Student ranga = new Student("Student1", "Ranga Karanam",
				"Hiker, Programmer and Architect", new ArrayList<>(Arrays
						.asList(course1, course2, course3, course4)));

		Student satish = new Student("Student2", "Satish T",
				"Hiker, Programmer and Architect", new ArrayList<>(Arrays
						.asList(course1, course2, course3, course4)));

		students.add(ranga);
		students.add(satish);
	}
	
	public List<Student> retrieveAllStudent(){
		return students;
	}
	
	public Student retrieveStudent(String id) {		
		Student student = (Student)students.stream().filter(st -> st.getId().equals(id)).collect(Collectors.toList()).get(0);
		return student;
	}
	
	public List<Course> retrieveCourses(String studentId){
		Student student = retrieveStudent(studentId);
		if(student==null) return null;
//		return student.getCourses();
		return Optional.ofNullable(student).isPresent()? student.getCourses(): null;
	}
	
	public Course retrieveCourse(String studentId, String courseId) {
		Student stud = retrieveStudent(studentId);
		if(stud == null) return null;
		
		for(Course course: stud.getCourses()) {
			if(course.getId().equals(courseId)) return course;
		}
		return stud.getCourses().stream()
				.filter(course -> course.getId().equals(courseId))
				.collect(Collectors.toList()).get(0);
	}
	
	private SecureRandom random = new SecureRandom();
	
	public Course addCourse(String studentId, Course course) {
		Student student = retrieveStudent(studentId);
		if(student ==null) return null;
		String randomId = new BigInteger(130, random).toString();
		course.setId(randomId);
		student.getCourses().add(course);
		return course;
	}
}
