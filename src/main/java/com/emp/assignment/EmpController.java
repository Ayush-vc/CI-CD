package com.emp.assignment;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@RequestMapping("hello")

public class EmpController {
    @RequestMapping("hello")
    public String hello(){
        return "hello world";
    }
    @Autowired
	private EmployeeService employeeService;

	@RequestMapping("/employees")
	public List<Employee> getemployees() {
		return employeeService.getemployees();
		

	}
	
	@RequestMapping(method=RequestMethod.POST, value="/employees")
	public void addEmployee(@RequestBody Employee Employee) {
		employeeService.addEmployee(Employee);
	}
	
	@RequestMapping("/employees/{id}")
	public Optional<Employee> getEmployee(@PathVariable String id){
		System.out.println("Inside getEmployee");
		return employeeService.getEmployee(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/employees/{id}")
	public void updateEmployee(@RequestBody Employee Employee, @PathVariable String id) {
		System.out.println("inside updateEmployee");
		employeeService.updateEmployee(id, Employee);
	}


	@RequestMapping(method=RequestMethod.DELETE, value="/employees/{id}")
	public void deleteEmployee(@PathVariable String id){
		System.out.println("Inside deleteEmployee");
		employeeService.deleteEmployee(id);
	}
}
