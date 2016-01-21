package com.web.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.db.entities.Course;
import com.db.services.CourseService;

@RestController
public class CourseResource {

	private Logger LOGGER = LoggerFactory.getLogger(CourseResource.class);
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value="/api/courses", method={RequestMethod.GET})
	public List<Course> findAllCourses() {
		LOGGER.info("RestController : findAllCourses()");
		return courseService.findAll();
		
	}
	
	@RequestMapping(value="/api/course", method={RequestMethod.GET})
	public Course findCourseById(@RequestParam(value="id") Long id) {
		LOGGER.info("RestController : findById()");
		return courseService.findById(id);
		
	}
	
}
