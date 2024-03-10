package com.SpringDemo.SpringLearning.service;

import java.io.Console;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.SpringDemo.SpringLearning.error.DepartmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringDemo.SpringLearning.entity.Department;
import com.SpringDemo.SpringLearning.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Department saveDepartment(Department department) {
		
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> fetchDepartmentsList() {
	
		return departmentRepository.findAll();
	}

	@Override
	public Department fetchDepartmentByID(Long departmentId) throws DepartmentNotFoundException {
		Optional<Department> department = departmentRepository.findById(departmentId);
		if(!department.isPresent()){
			throw  new DepartmentNotFoundException("Department not available");
		}
		return department.get();
	}

	@Override
	public void deleteDepartmentById(Long departmentId) {
		departmentRepository.deleteById(departmentId);
	}

	  @Override
	  public Department updateDepartment(Long departmnetId, Department department) {
		Department department2 =
	  departmentRepository.findById(departmnetId).get();

	  if(Objects.nonNull(department.getDepartmentName()) &&
	  !"".equalsIgnoreCase(department.getDepartmentName())) {
	  department2.setDepartmentName(department.getDepartmentName()); }

	  if(Objects.nonNull(department.getDepartmentAddress()) &&
	  !"".equalsIgnoreCase(department.getDepartmentAddress())) {
	  department2.setDepartmentAddress(department.getDepartmentAddress()); }

	  if(Objects.nonNull(department.getDeaprtmentCode()) &&
	  !"".equalsIgnoreCase(department.getDeaprtmentCode())) {
	 department2.setDeaprtmentCode(department.getDeaprtmentCode()); }

	  return departmentRepository.save(department2);
	}

	@Override
	public Department fetchDepartmentByName(String departmentName) {
		return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
	}

}
