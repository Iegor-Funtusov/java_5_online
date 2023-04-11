package ua.com.alevel.entity;

import ua.com.alevel.annotations.Entity;
import ua.com.alevel.annotations.Id;
import ua.com.alevel.annotations.Table;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
