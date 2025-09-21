package com.AdvancedDemo.CustomCrud.controller;


import com.AdvancedDemo.CustomCrud.model.Employee;
import com.AdvancedDemo.CustomCrud.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")

public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // CRUD API's:
    // Create / Add New Dept:
    @PostMapping("/add/{deptId}")
    public Employee addEmployee(@PathVariable Long deptId, @Valid @RequestBody Employee emp){
        return employeeService.addEmp(deptId, emp);
    }

    // Get List of All Emp:
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmp();
    }

    // Get Emp By ID:
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmpById(id);
    }

    // Update Emp By ID:
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee emp){
        return employeeService.updateEmp(id, emp);
    }

    // Delete Emp By ID:\
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmp(id);
        return "Employee Deleted Successfully";
    }


    // CUSTOM API's:
    // Get Emp By Dept ID:
    @GetMapping("/by-dept/{deptId}")
    public List<Employee> getEmployeesByDept(@PathVariable  Long deptId){
        return employeeService.getEmpByDept(deptId);
    }

    // Filter Emp By Salary:
    @GetMapping("/filter-salary")
    public List<Employee> filterEmployees(@RequestParam double salary){
        return employeeService.filterEmpBySalary(salary);
    }

    // Get Emp Details:
    @GetMapping("/{id}/details")
    public String getEmployeeDetails(@PathVariable Long id){
        return employeeService.getEmpDetails(id);
    }

    // Get Dept Salary Expense:
    @GetMapping("/dept-salary/{deptId}")
    public double getDeptSalaryExpenses(@PathVariable Long deptId){
        return employeeService.getDeptSalaryExpense(deptId);
    }

}
