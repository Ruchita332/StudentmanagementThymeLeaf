package com.ruchi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ruchi.entity.Student;
import com.ruchi.service.impl.StudentServiceImpl;

@Controller
public class StudentController {
	@Autowired
	private StudentServiceImpl daoService;
	
	@RequestMapping	("/")
	public String home_page() {
		return "redirect:add";
	}
	
	@RequestMapping	("/add")
	public String loadNewStudentForm(Model model) {
		
		String msg = "hello";
		model.addAttribute("msg", msg);
		
		Student stu = new Student();
		model.addAttribute("stu", stu);
		
		return "addStudentForm";
	}
	
	@RequestMapping	("/save")
	public String handleStudentInfo(@ModelAttribute("stu") Student stu, Model model ) {
		
		boolean save_stu = daoService.saveStudent(stu);
		String msg = "";
		if (save_stu) {
			msg ="Student Info was successfully saved";
		}
		else
			msg= "Error! Student Info couldn't be saved";
		
		model.addAttribute ("msg", msg);
	
		
		return "redirect:/viewAll";
	}
	
	@RequestMapping ("/viewAll")
	public String displayAllStudent (Model model) {
		List<Student> stuList = daoService.getAllStudent();
		
		model.addAttribute("stuList", stuList);
		return "displayStuList";
	}
	
	@RequestMapping("/edit")
	public String loadEditForm (@RequestParam("id") int id, Model model) {
		Student edit_stu= daoService.getStudentById(id);
		model.addAttribute("stu", edit_stu);
	return "editStuForm";
	}
	
	@RequestMapping("/update")
	public String handleEditReq (@ModelAttribute("stu") Student stu) {
		boolean edit_success = daoService.updateStudentInfo(stu);
	return "redirect:/viewAll";
	}
	
	@RequestMapping("/delete/{id}")
	public String handleDeleteReq(@PathVariable("id") int id, Model model) {
		boolean delete_success= daoService.deleteStudent(id);
	return "redirect:/viewAll";
	}
}
