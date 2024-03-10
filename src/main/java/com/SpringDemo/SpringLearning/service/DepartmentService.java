package com.SpringDemo.SpringLearning.service;

import java.util.List;

import com.SpringDemo.SpringLearning.error.DepartmentNotFoundException;
import org.springframework.stereotype.Service;

import com.SpringDemo.SpringLearning.entity.Department;

@Service
public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchDepartmentsList();

	public Department fetchDepartmentByID(Long departmentId) throws DepartmentNotFoundException;

	public void deleteDepartmentById(Long departmentId);

	public Department updateDepartment(Long departmnetId, Department department);

	public Department fetchDepartmentByName(String departmentName);

}
