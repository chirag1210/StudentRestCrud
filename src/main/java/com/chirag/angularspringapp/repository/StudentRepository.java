package com.chirag.angularspringapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chirag.angularspringapp.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
