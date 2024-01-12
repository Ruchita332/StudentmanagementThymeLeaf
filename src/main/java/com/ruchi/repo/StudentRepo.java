package com.ruchi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ruchi.entity.Student;


public interface StudentRepo extends JpaRepository<Student, Integer> {

}
