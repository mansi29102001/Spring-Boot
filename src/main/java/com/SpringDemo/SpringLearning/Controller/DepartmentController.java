package com.SpringDemo.SpringLearning.Controller;

import java.util.List;

import com.SpringDemo.SpringLearning.error.DepartmentNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringDemo.SpringLearning.entity.Department;
import com.SpringDemo.SpringLearning.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		logger.info("Inside save department of department controller");
		return departmentService.saveDepartment(department);
		
	}
	
	@GetMapping("/departments")
	public List<Department> fetchDepartmentsList(){
		logger.info("Inside fetch department of department controller");
		return departmentService.fetchDepartmentsList();
	}
	
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentByID(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
		return departmentService.fetchDepartmentByID(departmentId);
		
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
		departmentService.deleteDepartmentById(departmentId);
		return "Department deleted successfully!!";	
	}
	

	 @PutMapping("/departments/{id}")
	 public Department updateDepartment(@PathVariable("id") Long departmnetId, @RequestBody
	  Department department) {
		return departmentService.updateDepartment(departmnetId,department);
	 }

	
	@GetMapping("/departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
		return departmentService.fetchDepartmentByName(departmentName);
		
	}
	
}
