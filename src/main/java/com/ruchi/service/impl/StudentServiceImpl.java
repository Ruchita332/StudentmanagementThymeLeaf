package com.ruchi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruchi.entity.Student;
import com.ruchi.repo.StudentRepo;
import com.ruchi.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepo daoImpl;
	
	@Override
	public boolean saveStudent(Student stu) {
		// TODO Auto-generated method stub
		Student s=daoImpl.save(stu);
		
		if (s != null) {
			//Student successfully saved
			return true;
		}
		else
			return false;
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		List<Student> stuList = daoImpl.findAll();
		return stuList;
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		Student s = daoImpl.findById(id).get();
		return s;
	}

	@Override
	public boolean updateStudentInfo(Student stu) {
		// TODO Auto-generated method stub
		 return saveStudent(stu);
	}

	@Override
	public boolean deleteStudent(int id) {
		// TODO Auto-generated method stub
		Student delete_stu = getStudentById(id);
		
		if (delete_stu != null) {
			//student found 
			//execute delete
			daoImpl.delete(delete_stu);
			return true;
		}
		else
			return false;
	}

}
