package ua.com.alevel.service.crud.product.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.data.datatable.DataTableRequest;
import ua.com.alevel.persistence.sql.entity.product.ProductImage;
import ua.com.alevel.service.crud.product.ProductImageCrudService;

@Service
@Transactional
public class ProductImageCrudServiceImpl implements ProductImageCrudService {

    @Override
    public void create(ProductImage entity) {

    }

    @Override
    public void update(ProductImage entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public ProductImage findById(Long id) {
        return null;
    }

    @Override
    public Page<ProductImage> findAll(DataTableRequest request) {
        return null;
    }
}
