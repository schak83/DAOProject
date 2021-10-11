package com.cvv.springboot.h2.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cvv.springboot.h2.dao.EmployeeRepository;
import com.cvv.springboot.h2.model.Employee;
import com.cvv.springboot.h2.model.NewEmployee;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping("/createEmployee")
	public String createEmployee(@RequestBody Employee employee){
		employeeRepository.save(employee);
		return"Employee Saved"; 
	}
	
	@GetMapping("/getAllEmployees")
	public List<NewEmployee> getAllEmployees()	{
		List<Employee> tempList = employeeRepository.findAll();
		return tempList.parallelStream().filter(e -> e.getSalary()>=1 && e.getSalary()<=10000).map(e->mapEmployee(e)).collect(Collectors.toList());
	}
	
	@GetMapping("/getEmployees/{dept}")
	public List<Employee> getEmployeesByDept(@PathVariable String dept){
		return employeeRepository.findByDept(dept);
	}
	private NewEmployee mapEmployee(Employee emp) {
		NewEmployee newEmployee = new NewEmployee();
		newEmployee.setEmpName(emp.getName());
		newEmployee.setEmpSalary(emp.getSalary());
		return newEmployee;
	}
	
}
