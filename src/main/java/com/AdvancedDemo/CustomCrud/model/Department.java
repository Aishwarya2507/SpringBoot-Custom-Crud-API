package com.AdvancedDemo.CustomCrud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
//@Getter
//@Setter
@Data             // ✅ enough: includes getters/setters, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "department")

public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Department name is required")
    private String dept_name;

    private String location;



    // Declares that one Department has many Employees.
    // mappedBy:tells Hibernate which field in Employee entity owns relationship.
    // cascade = CascadeType.ALL: Means all operations (persist, merge, remove,
    // refresh, detach) on Department will cascade to its employees.
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees;
    // Holds the collection of employees belonging to the department.
    // JPA will fetch this list when queried
    // (depending on fetch type → default is LAZY for @OneToMany).

}
