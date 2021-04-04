package com.chirag.angularspringapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chirag.angularspringapp.error.CustomException;
import com.chirag.angularspringapp.model.Message;
import com.chirag.angularspringapp.model.Student;
import com.chirag.angularspringapp.serviceimpl.StudentServiceImpl;
import com.chirag.angularspringapp.validationUtil.StudentRequestValidationUtil;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

	@Autowired
	StudentServiceImpl studentService;

	@Autowired
	StudentRequestValidationUtil validationUtil;

	@PostMapping(value = "/student")
	public ResponseEntity<Message> createStudent(@Valid @RequestBody Student student) {

		ResponseEntity<Message> resp = null;
		try {
			Integer id = (int) studentService.createStudent(student);
			resp = new ResponseEntity<Message>(new Message("SUCCESS", id + "-saved"), HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<Message>(new Message("FAIL", "Unable to Save"), HttpStatus.OK);
			e.printStackTrace();
		}
		return resp;

	}

	@GetMapping(value = "/student/{id}")
	public ResponseEntity<?> getStudent(@PathVariable long id) throws CustomException {

		ResponseEntity<?> resp = null;
		try {
			validationUtil.validateEmployeeId(id);
			Student student = studentService.getStudentById(id);
			if (student != null)
				resp = new ResponseEntity<Student>(student, HttpStatus.OK);
			else
				resp = new ResponseEntity<String>("No Data Found", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<String>("Unable to fetch Data", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

	@PutMapping(value = "/student")
	public ResponseEntity<Message> updateStudent(@Valid @RequestBody Student student) {

		ResponseEntity<Message> resp = null;
		try {
			boolean exist = studentService.isExist(student.getStdId());
			if (exist) {
				studentService.createStudent(student);
				resp = new ResponseEntity<Message>(new Message("OK", student.getStdId() + "-Updated"), HttpStatus.OK);
			} else {
				resp = new ResponseEntity<Message>(new Message("OK", student.getStdId() + "-Not Exist"),
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			resp = new ResponseEntity<Message>(new Message("OK", "Unable to Update"), HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;

	}

	@DeleteMapping(value = "/student/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable int id) throws CustomException {

		ResponseEntity<Message> resp = null;
		try {
			validationUtil.validateEmployeeId(id);
			boolean exist = studentService.isExist(id);
			if (exist) {
				studentService.deleteStudent(id);
				resp = new ResponseEntity<Message>(new Message("SUCCESSS", id + "-removed"), HttpStatus.OK);
			} else {

				resp = new ResponseEntity<Message>(new Message("FAIL", id + "-Not Exist"), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			resp = new ResponseEntity<Message>(new Message("FAIL", "Unable to Delete"),
					HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

	@GetMapping(value = "/students")
	public ResponseEntity<?> getStudent() {

		ResponseEntity<?> resp = null;
		try {
			List<Student> studentList = studentService.getStudents();
			if (studentList != null && !studentList.isEmpty())
				resp = new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
			else
				resp = new ResponseEntity<Message>(new Message("SUCCESSS", "Data Not Found!"), HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<Message>(new Message("FAIL", "Unable to Fetch data!"),
					HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}
}
