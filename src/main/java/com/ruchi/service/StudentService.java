package com.ruchi.service;

import java.util.List;

import com.ruchi.entity.Student;

public interface StudentService {
	public boolean saveStudent (Student stu);
	public List<Student> getAllStudent ();
	public Student getStudentById (int id);
	public boolean updateStudentInfo (Student stu);
	public boolean deleteStudent (int id);

}
