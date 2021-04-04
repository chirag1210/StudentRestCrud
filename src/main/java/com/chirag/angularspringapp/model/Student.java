package com.chirag.angularspringapp.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="tb_student")
public class Student implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long stdId;
	
	
	@NotEmpty(message = "first_name  must not be empty")
	@Column(name="student")
	private String stdName;
	
	
	@Column(name="student_fee")
	private Double stdFee;
	
	@NotEmpty(message = "student_course must not be empty")
	@Column(name="student_course")
	private String stdCourse;

	public long getStdId() {
		return stdId;
	}

	public String getStdName() {
		return stdName;
	}

	public Double getStdFee() {
		return stdFee;
	}

	public String getStdCourse() {
		return stdCourse;
	}

	public void setStdId(long stdId) {
		this.stdId = stdId;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public void setStdFee(Double stdFee) {
		this.stdFee = stdFee;
	}

	public void setStdCourse(String stdCourse) {
		this.stdCourse = stdCourse;
	}
	
}
