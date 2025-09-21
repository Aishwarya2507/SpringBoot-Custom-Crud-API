package com.AdvancedDemo.CustomCrud.service;

import com.AdvancedDemo.CustomCrud.model.Department;

import java.util.List;

public interface DepartmentService {

    // CRUD API's:
    // Create / Add New Dept:
    Department addDepartment(Department dept);

    // Get All Dept List:
    List<Department> getAllDepartments();

    // Get Dept By ID:
    Department getDepartmentById(Long id);

    // Update Dept By ID:
    Department updateDepartment(Long id, Department department);

    // Delete Dept By ID:
    void deleteDepartment(Long id);

}
