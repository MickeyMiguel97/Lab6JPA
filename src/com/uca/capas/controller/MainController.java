package com.uca.capas.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.StudentDAO;
import com.uca.capas.domain.Student;

@Controller
public class MainController {
	
	@Autowired
	private StudentDAO studentDao;
	
	static Logger log = Logger.getLogger(MainController.class.getName());
	
	@RequestMapping ("/")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		List<Student> students = null;
		try {
		 students = studentDao.findAll();
		 log.info("Termino de Buscar en la Base de Datos");
		}
		catch(Exception e){
			e.printStackTrace();
			log.log(Level.SEVERE,"Exception Occur");
		}
		mav.addObject("students",students);
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping (value="/save",method=RequestMethod.POST)
	public ModelAndView insert() {
		ModelAndView mav =  new ModelAndView();
		mav.addObject("students",new Student());
		mav.setViewName("form");
		return mav;
		
	}
	
	@RequestMapping("/form")
	public ModelAndView main2(@RequestParam(value="code")Integer code ){
		ModelAndView mav = new ModelAndView();
			Student students = null;
			try {
				 students = studentDao.findOne(code);
				 log.info("Termino de Buscar por codigo en la Base de Datos");
				}
				catch(Exception e){
					e.printStackTrace();
					log.log(Level.SEVERE,"Exception Occur");
				}
				mav.addObject("students",students);
				mav.setViewName("form");
		return mav;
		
	}
	
	
	
	@RequestMapping ("/formData")
	ModelAndView save(@ModelAttribute Student s) {
		ModelAndView mav = new ModelAndView();
		List<Student> students = null;
		try {
			log.info("Agrego un nuevo usuario");
			studentDao.save(s, 1);
			
			
		}catch (Exception e) {
			log.info("Error: "+e.toString() );
		}
		students = studentDao.findAll();
		log.info(students.get(0).getlName());
		mav.addObject("students",students);
		mav.setViewName("main");
		return mav;
	}
	
}