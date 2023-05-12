package ua.com.alevel.service.crud.product.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.alevel.data.datatable.DataTableRequest;
import ua.com.alevel.persistence.sql.entity.product.Product;
import ua.com.alevel.persistence.sql.repository.product.ProductRepository;
import ua.com.alevel.service.crud.CrudHelperService;
import ua.com.alevel.service.crud.product.ProductCrudService;

import java.util.Collection;

@Service
@Transactional
public class ProductCrudServiceImpl implements ProductCrudService {

    private final ProductRepository productRepository;
    private final CrudHelperService<Product, ProductRepository> crudHelperService;

    public ProductCrudServiceImpl(ProductRepository productRepository, CrudHelperService<Product, ProductRepository> crudHelperService) {
        this.productRepository = productRepository;
        this.crudHelperService = crudHelperService;
    }

    @Override
    public void create(Product entity) {
        crudHelperService.create(entity, productRepository);
    }

    @Override
    public void update(Product entity) {
        crudHelperService.update(entity, productRepository);
    }

    @Override
    public void delete(Long id) {
        crudHelperService.delete(id, productRepository);
    }

    @Override
    public Product findById(Long id) {
        return crudHelperService.findById(id, productRepository);
    }

    @Override
    public Page<Product> findAll(DataTableRequest request) {
        return crudHelperService.findAll(request, productRepository);
    }

    @Override
    public Collection<Product> findAll() {
        return productRepository.findAll();
    }
}
