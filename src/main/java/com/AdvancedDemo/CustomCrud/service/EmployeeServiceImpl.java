package com.AdvancedDemo.CustomCrud.service;


import com.AdvancedDemo.CustomCrud.model.Department;
import com.AdvancedDemo.CustomCrud.model.Employee;
import com.AdvancedDemo.CustomCrud.repository.DepartmentRepository;
import com.AdvancedDemo.CustomCrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    // CRUD API's:
    // Create/Add new Emp:
    @Override
    public Employee addEmp(Long deptId, Employee emp) {
        Department dept = departmentRepository.findById(deptId)
                .orElseThrow(() -> new RuntimeException("Department not Found"));
        emp.setDepartment(dept);
        return employeeRepository.save(emp);
    }

    // Get List of All Emp:
    @Override
    public List<Employee> getAllEmp() {
        return employeeRepository.findAll();
    }

    // Get Emp By ID:
    @Override
    public Employee getEmpById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not Found with this id: " + id));
    }

    // Update Emp By ID:
    @Override
    public Employee updateEmp(Long id, Employee updatedEmp) {
        Employee emp = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        emp.setName(updatedEmp.getName());
        emp.setEmail(updatedEmp.getEmail());
        emp.setSalary(updatedEmp.getSalary());
        emp.setDepartment(updatedEmp.getDepartment());

        return employeeRepository.save(emp);
    }

    // Delete Emp By ID:
    @Override
    public void deleteEmp(Long id) {
        employeeRepository.deleteById(id);
    }


    // CUSTOM API's:
    // Get Emp By Dept ID:
    @Override
    public List<Employee> getEmpByDept(Long deptId) {
        Department dept = departmentRepository.findById(deptId)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        return dept.getEmployees();
    }

    // Filter Emp By Salary:
    @Override
    public List<Employee> filterEmpBySalary(double salary) {
        return employeeRepository.findAll().stream()
                .filter(e -> e.getSalary() > salary)
                .toList();
    }

    // Get Emp Details:
    @Override
    public String getEmpDetails(Long id) {
        Employee employees = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not Found"));
        return employees.getName() + " works in " + employees.getDepartment()
                + " at " + employees.getDepartment().getLocation();
    }

    // Get Dept Salary Expense:
    @Override
    public double getDeptSalaryExpense(Long deptId) {
        Department department = departmentRepository.findById(deptId)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        return department.getEmployees().stream().mapToDouble(Employee::getSalary).sum();
    }

}
