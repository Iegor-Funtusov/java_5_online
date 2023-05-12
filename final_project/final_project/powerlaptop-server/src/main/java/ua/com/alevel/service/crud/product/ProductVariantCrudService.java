package ua.com.alevel.service.crud.product;

import ua.com.alevel.persistence.sql.entity.product.Product;
import ua.com.alevel.persistence.sql.entity.product.ProductVariant;
import ua.com.alevel.service.crud.CrudService;

public interface ProductVariantCrudService extends CrudService<ProductVariant> {

    ProductVariant findByProduct(Product product);
}
