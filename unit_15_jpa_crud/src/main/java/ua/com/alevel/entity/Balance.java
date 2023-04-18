package ua.com.alevel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "balances")
public class Balance extends BaseEntity {

    private Long salary;

    @OneToOne
    private Employee employee;
}
