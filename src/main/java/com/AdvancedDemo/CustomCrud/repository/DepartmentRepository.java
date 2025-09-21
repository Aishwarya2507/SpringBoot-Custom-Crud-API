package com.AdvancedDemo.CustomCrud.repository;

import com.AdvancedDemo.CustomCrud.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
