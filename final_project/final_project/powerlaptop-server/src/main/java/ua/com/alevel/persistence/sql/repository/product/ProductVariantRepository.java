package ua.com.alevel.persistence.sql.repository.product;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.sql.entity.product.ProductVariant;
import ua.com.alevel.persistence.sql.repository.BaseEntityRepository;

@Repository
public interface ProductVariantRepository extends BaseEntityRepository<ProductVariant> { }
