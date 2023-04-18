package ua.com.alevel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cars")
public class Car extends BaseEntity {

    private String name;

    @ManyToOne
    private Employee employee;
}
