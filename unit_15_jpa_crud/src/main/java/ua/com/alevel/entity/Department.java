package ua.com.alevel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "departments")
public class Department extends BaseEntity {

    private String name;

    @ManyToMany
    @JoinTable(
            name = "dep_emp",
            joinColumns = @JoinColumn(name = "dep_id"),
            inverseJoinColumns = @JoinColumn(name = "emp_id")
    )
    private Set<Employee> employees = new HashSet<>();
}
