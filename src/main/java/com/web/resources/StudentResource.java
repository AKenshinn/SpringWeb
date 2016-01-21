package com.web.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.db.entities.Student;
import com.db.services.StudentService;

@RestController
public class StudentResource {

	private Logger LOGGER = LoggerFactory.getLogger(StudentResource.class);
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/api/students", method={RequestMethod.GET})
	public List<Student> findAllStudents() {
		LOGGER.info("RestController : findAllStudents()");
		return studentService.findAll();
		
	}
	
	@RequestMapping(value="/api/student", method={RequestMethod.GET})
	public Student findStudentById(@RequestParam(value="id") Long id) {
		LOGGER.info("RestController : findStudentById()");
		return studentService.findById(id);
		
	}
	
}
