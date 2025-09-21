package com.AdvancedDemo.CustomCrud.service;


import com.AdvancedDemo.CustomCrud.model.Department;
import com.AdvancedDemo.CustomCrud.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements  DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // CRUD API's:
    // Create / Add New Dept:
    @Override
    public Department addDepartment(Department dept) {
        return departmentRepository.save(dept);
    }

    // Get All Dept List:
    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // Get Dept By ID:
    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }

    // Update Dept By ID:
    @Override
    public Department updateDepartment(Long id, Department department) {
        Department departmentExist = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        departmentExist.setDept_name(department.getDept_name());
        departmentExist.setLocation(department.getLocation());

        return departmentRepository.save(departmentExist);
    }

    // Delete Dept By ID:
    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);

    }
}
