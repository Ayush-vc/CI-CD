package com.emp.assignment;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired
	private EmpDAOrepository empDAOrepository;
	
	public List<Employee> getemployees(){
		List<Employee> empList = new ArrayList<Employee>();
		empDAOrepository.findAll().forEach(empList::add);
		return empList;
		
	}
	
	public Optional<Employee> getEmployee(String id) {
		return empDAOrepository.findById(id);
	}
	
	public void updateEmployee(String id, Employee Employee) {
		empDAOrepository.save(Employee);
	}

	public void deleteEmployee(String id) {
		empDAOrepository.deleteById(id);
	}

	
	public void addEmployee(Employee employee) {
		empDAOrepository.save(employee);
	}
}
