package com.hefsp.TekvisionTask.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hefsp.TekvisionTask.model.Employee;

//A repository is a interface that extends JPARepository.
// repository provides methods for basic CRUD operations, such as save(), findById(), findAll(), deleteById()

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	Employee findById(Long id);


	
}
