package com.AdvancedDemo.CustomCrud.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
//@Getter
//@Setter
@Data         // ✅ enough: includes getters/setters, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Email(message = "Invalid email format")
    @Column(unique = true)
    private String email;

    @Min(value = 10000, message = "Salary must be >= 10000")
    private double salary;


    // Many Employees belong to One Department.
    // @JoinColumn(name = "dept_id"): Specifies foreign key column in Employee table.
    // The column will be named dept_id and it will store the department’s id.
    // Without this, Hibernate would auto-generate a column like department_id.
    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;
    // private Department department: This creates relationship field in Employee
    // entity pointing to its department. It links each employee record to a specific department.


}
