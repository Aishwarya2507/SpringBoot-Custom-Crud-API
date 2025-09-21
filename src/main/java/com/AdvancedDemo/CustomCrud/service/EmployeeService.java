package com.AdvancedDemo.CustomCrud.service;


import com.AdvancedDemo.CustomCrud.model.Employee;

import java.util.List;

public interface EmployeeService {

    // CRUD API's:
    // Create/Add new Emp:
    Employee addEmp(Long deptId, Employee updatedEmp);

    // Get List of All Emp:
    List<Employee> getAllEmp();

    // Get Emp By ID:
    Employee getEmpById(Long id);

    // Update Emp By ID:
    Employee updateEmp(Long id, Employee emp);

    // Delete Emp By ID:
    void deleteEmp(Long id);

    // CUSTOM API's:
    // Get Emp By Dept ID:
    List<Employee> getEmpByDept(Long deptId);

    // Filter Emp By Salary:
    List<Employee> filterEmpBySalary(double salary);

    // Get Emp Details:
    String getEmpDetails(Long id);

    // Get Dept Salary Expense:
    double getDeptSalaryExpense(Long deptId);

}
