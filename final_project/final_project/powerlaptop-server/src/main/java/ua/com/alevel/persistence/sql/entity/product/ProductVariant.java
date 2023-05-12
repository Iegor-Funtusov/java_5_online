package ua.com.alevel.persistence.sql.entity.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import ua.com.alevel.persistence.sql.entity.BaseEntity;
import ua.com.alevel.persistence.sql.type.DisplayType;
import ua.com.alevel.persistence.sql.type.OsType;

@Getter
@Setter
@Entity
@Table(name = "product_variants")
public class ProductVariant extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OsType os;

    @Column(nullable = false)
    private String cpu;

    @Column(nullable = false)
    private Integer ram;

    @Column(nullable = false)
    private Integer ssd;

    @Column(nullable = false)
    private String color;

    @Column(name = "display_resolution", nullable = false)
    private String displayResolution;

    @Enumerated(EnumType.STRING)
    @Column(name = "display_type", nullable = false)
    private DisplayType displayType;

    @Column(name = "display_size", nullable = false)
    private String displaySize;

    @ManyToOne
    private Product product;
}
