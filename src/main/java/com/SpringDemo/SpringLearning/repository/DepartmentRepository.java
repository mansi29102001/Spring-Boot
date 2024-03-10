package com.SpringDemo.SpringLearning.repository;

import org.springframework.boot.autoconfigure.pulsar.PulsarProperties.Consumer.DeadLetterPolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringDemo.SpringLearning.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

	public Department findByDepartmentName(String departmentName);
	
	public Department findByDepartmentNameIgnoreCase(String departmentName);
}
