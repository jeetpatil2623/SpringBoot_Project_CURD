package com.hefsp.TekvisionTask.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hefsp.TekvisionTask.model.Employee;
import com.hefsp.TekvisionTask.repository.EmployeeRepo;


//This class of RESTful API controller for employee registration and management.
//this controller provides end points to register new employees, retrieve all => 
//employees, delete employees by ID, update employee information, and retrieve employee information by ID.

@CrossOrigin(origins = "*")
@RestController					//this Annotations handles HTTP requests
@RequestMapping("register")		//sets the base URL path as '/register'
public class MyController {
	
	//Dependency Injection @Autuwired annotation is used to controller and access 
	//repository methods and perform database operations.
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	
	//This mapping is used for Store Data in Database.
	
	@PostMapping("registerEmployee")
	public boolean registerEmpolyee(@RequestBody Employee employee)
	{
		try {
			
				employeeRepo.save(employee);
				System.out.println(employee);
				return true;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//This mapping is used for Get Data from Database.
	
	@GetMapping("GetEmployees")
	public List<Employee> GetEmployees()
	{
		try {
			List<Employee> list=employeeRepo.findAll();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//This mapping is used for Delete particular record from Database.
	
	@DeleteMapping("/delete{id}")
	public boolean DeleteEmployees(@PathVariable int id)
	{
		try {
			boolean count=employeeRepo.existsById(id);
			if(count)
			{
				employeeRepo.deleteById(id);
				return true;
			}
			else
			{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//This mapping is used for Update Data in Database.
	
	@PutMapping("/save")
	public Boolean UpdateEmployee(@RequestBody Employee employee)
	{
		try {
			boolean existsById = employeeRepo.existsById(employee.getId());
			if(existsById) {
				Optional<Employee> emp = employeeRepo.findById(employee.getId());
				Employee emp2 = emp.get();
				emp2.setFirstname(employee.getFirstname());
				emp2.setLastname(employee.getLastname());
				emp2.setContactno(employee.getContactno());
				emp2.setAddress(employee.getAddress());
				
				employeeRepo.save(emp2);
				System.out.println(employee);
				return true;
			}
			else
			return false;
		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//This mapping is used for Get Particular record from Database.
	
	@GetMapping("/getEmployeeInfo{id}")
	public Employee GetEmployeeInfo(@PathVariable long id)
	{
		try {
			 Employee emp = employeeRepo.findById(id);
			System.out.println(emp);
			return emp;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	

}
