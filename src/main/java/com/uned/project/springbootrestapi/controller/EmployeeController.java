package com.uned.project.springbootrestapi.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uned.project.springbootrestapi.dao.EmployeeDAO;
import com.uned.project.springbootrestapi.model.Employee;

@RestController
@RequestMapping ("/company")
@CrossOrigin // error de CORS: has been blocked by CORS policy: No 'Access-Control-Allow-Origin' header is present on the requested resource.
public class EmployeeController {
	
	@Autowired
	EmployeeDAO employeeDAO;
	
	/* to save an employee*/
	@PostMapping ("/employees")
	public Employee createEmployee (@Valid @RequestBody Employee emp) {
		return employeeDAO.save(emp);
	}

	/* get all employee */
	@GetMapping ("/employees")
	public List<Employee> getAllEmployees() {
		return employeeDAO.findAll(); 
	}
	
	/* get employee by empid*/
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable (value = "id") Long empid){
		
		Employee emp=employeeDAO.findOne(empid);
		if (emp==null) {
			return ResponseEntity.notFound().build();
		}
		return  ResponseEntity.ok().body(emp) ;
	}
	
	/*update an employee by empid */
	@PutMapping ("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Long empid , @Valid @RequestBody Employee empDetails){
		
		Employee emp=employeeDAO.findOne(empid);
		if (emp==null) {
			return ResponseEntity.notFound().build();
		}
		
		emp.setName(empDetails.getName());
		emp.setDesignation(empDetails.getDesignation());
		emp.setExpertise(empDetails.getExpertise());
		
		Employee updateEmployee=employeeDAO.save(emp);
		return  ResponseEntity.ok().body(updateEmployee) ;
		
	}
	
	
	/*delete an employee */
	@DeleteMapping ("/employee/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable (value="id") Long empid){
		
		Employee emp=employeeDAO.findOne(empid);
		if (emp==null) {
			return ResponseEntity.notFound().build();
		}
		
		employeeDAO.delete(emp);
		return ResponseEntity.ok().build();	
		
	}
	
	
	
	/* get numero de employee */
	@GetMapping("/cuantos")
	public long  getCuantosHay(){
		
		return  employeeDAO.cuantosHay() ;
	}
	
	
}// clase
