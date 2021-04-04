package com.chirag.angularspringapp.validationUtil;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.chirag.angularspringapp.error.CustomException;

@Component
public class StudentRequestValidationUtil {

	public void validateEmployeeId(long id)throws CustomException {
		if(id <= 0) {
			 throw new CustomException("Student Id Should be positive number", HttpStatus.BAD_REQUEST); 
		 }
	}
	
}
