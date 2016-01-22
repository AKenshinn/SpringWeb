package com.web.controllers;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.db.entities.Student;
import com.db.services.StudentService;

@Controller
public class StudentController {

	private Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentService studentService;
	
	@ModelAttribute(value="students")
	private List<Student> findAllStudents() {
		return studentService.findAll();
	}
	
	@RequestMapping(value = "/student", method = { RequestMethod.GET })
	public ModelAndView main() {
		LOGGER.info("Controller : main()");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("student");
		modelAndView.addObject("student", new Student());
		
		return modelAndView;
		
	}

	@RequestMapping(value = "/student/create", method={RequestMethod.POST})
	public String create(@ModelAttribute(value="student") Student student) {
		LOGGER.info("Controller : create()");
		LOGGER.info("ID:" + student.getId() + " FIRST_NAME:" + student.getFirstName() + 
				" LAST_NAME:" + student.getLastName());
		
		if (!StringUtils.isEmpty(student.getFirstName()) && !student.getFirstName().equals("") 
				&& !StringUtils.isEmpty(student.getLastName()) && !student.getLastName().equals("")) {
			student.setCreatedDateTime(new Date());
			student.setUpdatedDateTime(new Date());
			
			studentService.insert(student);
			
		}
		
		return "redirect:/student";
		
	}
	
	@RequestMapping(value="/student/update/{id}", method={RequestMethod.GET})
	public ModelAndView initUpdate(@PathVariable(value="id") Long id) {
		LOGGER.info("Find ID:" + id);
		
		Student student = studentService.findById(id);
		if (student == null) {
			LOGGER.info("Can't find when ID:" + id);
			student = new Student();
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("student");
		modelAndView.addObject("student", student);
		
		return modelAndView;
		
	}
	
	@RequestMapping(value="/student/update", method={RequestMethod.POST})
	public String update(@ModelAttribute(value="student") Student student) {
		LOGGER.info("Controller : update()");
		LOGGER.info("ID:" + student.getId() + " FIRST_NAME:" + student.getFirstName() + 
				" LAST_NAME:" + student.getLastName());
		
		Student update = studentService.findById(student.getId());
		
		if (!StringUtils.isEmpty(student.getFirstName()) && !student.getFirstName().equals("") 
				&& !StringUtils.isEmpty(student.getLastName()) && !student.getLastName().equals("")) {
			update.setFirstName(student.getFirstName());
			update.setLastName(student.getLastName());
			update.setUpdatedDateTime(new Date());
			
			studentService.update(update);
			
		}
		
		return "redirect:/student";
		
	}
	
	@RequestMapping(value="/student/delete/{id}", method={RequestMethod.GET})
	public String deleteById(@PathVariable(value="id") Long id) {
		LOGGER.info("Find ID:" + id);
		
		Student student = studentService.findById(id);
		if (student == null) {
			LOGGER.info("Can't find when ID:" + id);
		} else {
			studentService.deleteById(id);
		}
		
		return "redirect:/student";
		
	}

}
