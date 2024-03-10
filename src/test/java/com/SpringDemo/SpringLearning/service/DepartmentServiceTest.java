package com.SpringDemo.SpringLearning.service;

import com.SpringDemo.SpringLearning.entity.Department;
import com.SpringDemo.SpringLearning.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder().departmentId(1).departmentAddress("Ahmedabad").departmentName("IT").deaprtmentCode("IT-03").build();
        List<Department> list = new ArrayList<Department>();
        list.add(department);
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
        Mockito.when(departmentRepository.findAll()).thenReturn(list);
    }

    @Test
    @DisplayName("Get the data when department name is valid")
    public void whenValidDepartment_thenDepartmentShouldFind(){
        String departmentName = "IT";
        Department department = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName, department.getDepartmentName());
    }

    @Test
    public void getDepartmentList(){
        List<Department> departmentList = departmentRepository.findAll();
        assertEquals(departmentList.get(0).getDepartmentName(),"IT");
    }
}