package com.chirag.angularspringapp.service;

import java.util.List;

import com.chirag.angularspringapp.error.CustomException;
import com.chirag.angularspringapp.model.Student;

public interface IStudentService {

	public long createStudent(Student student);

	public Student getStudentById(long id) throws CustomException;

	public void updateStudent(Student student);
	
	public void deleteStudent(long id) throws CustomException;
	
	public List<Student> getStudents();
	
	public boolean isExist(long id);
	
}
