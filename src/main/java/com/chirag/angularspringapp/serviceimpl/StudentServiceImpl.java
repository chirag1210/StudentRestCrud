package com.chirag.angularspringapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.chirag.angularspringapp.error.CustomException;
import com.chirag.angularspringapp.model.Student;
import com.chirag.angularspringapp.repository.StudentRepository;
import com.chirag.angularspringapp.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService{

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public long createStudent(Student student) {
		return studentRepository.save(student).getStdId();
	}

	@Override
	public Student getStudentById(long id) throws CustomException {
		return studentRepository.getOne(id);
	}

	@Override
	public void updateStudent(Student student) {
		studentRepository.save(student);
	}

	@Override
	public void deleteStudent(long id) throws CustomException {
		studentRepository.deleteById(id);	
	}

	@Override
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	@Override
	public boolean isExist(long id) {
		return studentRepository.existsById(id);
	}
	
}
