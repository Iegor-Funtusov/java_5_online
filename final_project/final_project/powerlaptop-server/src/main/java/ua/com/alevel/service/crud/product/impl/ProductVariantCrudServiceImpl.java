package ua.com.alevel.service.crud.product.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.data.datatable.DataTableRequest;
import ua.com.alevel.persistence.sql.entity.product.ProductVariant;
import ua.com.alevel.service.crud.product.ProductVariantCrudService;

@Service
@Transactional
public class ProductVariantCrudServiceImpl implements ProductVariantCrudService {

    @Override
    public void create(ProductVariant entity) {

    }

    @Override
    public void update(ProductVariant entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public ProductVariant findById(Long id) {
        return null;
    }

    @Override
    public Page<ProductVariant> findAll(DataTableRequest request) {
        return null;
    }
}
