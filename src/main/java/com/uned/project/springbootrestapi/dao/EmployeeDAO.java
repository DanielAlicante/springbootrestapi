package com.uned.project.springbootrestapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uned.project.springbootrestapi.model.Employee;
import com.uned.project.springbootrestapi.repository.EmployeeRepository;

//Data Access Object es DAO
@Service
public class EmployeeDAO {

	// creamos objeto usamos repository y model
	@Autowired
	EmployeeRepository employeeRepository;
	
	/*to save an employee	 */
	public Employee save (Employee emp) {
		return employeeRepository.save(emp);
	}
	/* search all employee   */
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}
	
	/* get an employee by Id */
	public Employee findOne (long id) {
		return employeeRepository.getOne(id);
		
	}
	
	/* delete an employee	 */
	public void delete (Employee emp) {
		 employeeRepository.delete(emp);
	}	 
}
