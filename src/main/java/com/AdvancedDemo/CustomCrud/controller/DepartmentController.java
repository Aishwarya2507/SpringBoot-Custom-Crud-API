package com.AdvancedDemo.CustomCrud.controller;

import com.AdvancedDemo.CustomCrud.model.Department;
import com.AdvancedDemo.CustomCrud.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")

public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // CRUD API's:
    // Create / Add New Dept:
    @PostMapping("/add")
    public Department addDepartment(@Valid @RequestBody Department department){
        return departmentService.addDepartment(department);
    }

    // Get All Dept List:
    @GetMapping("")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    // Get Dept By ID:
    @GetMapping("/{id}")
    public Department getDepartmetById(@PathVariable Long id){
        return departmentService.getDepartmentById(id);
    }

    // Update Dept By ID:
    @PutMapping("/{id}")
    public Department upadateDepartment(@PathVariable Long id, @Valid @RequestBody Department department){
        return  departmentService.updateDepartment(id, department);
    }

    // Delete Dept By ID:
    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartment(id);
        return "Departmet Deleted Successfully";
    }



}
