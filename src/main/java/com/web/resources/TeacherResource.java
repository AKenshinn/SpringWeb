package com.web.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.db.entities.Teacher;
import com.db.services.TeacherService;

@RestController
public class TeacherResource {

	private Logger LOGGER = LoggerFactory.getLogger(TeacherResource.class);
	
	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping(value="/api/teachers", method={RequestMethod.GET})
	public List<Teacher> findAllTeachers() {
		LOGGER.info("RestController : findAllTeachers()");
		return teacherService.findAll();
		
	}
	
	@RequestMapping(value="/api/teacher", method={RequestMethod.GET})
	public Teacher findTeacherById(@RequestParam(value="id") Long id) {
		LOGGER.info("RestController : findTeacherById()");
		return teacherService.findById(id);
		
	}
	
	
}
