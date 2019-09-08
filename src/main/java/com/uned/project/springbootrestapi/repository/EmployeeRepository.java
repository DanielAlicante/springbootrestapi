package com.uned.project.springbootrestapi.repository;

import com.uned.project.springbootrestapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EmployeeRepository  extends JpaRepository<Employee, Long>{

}
