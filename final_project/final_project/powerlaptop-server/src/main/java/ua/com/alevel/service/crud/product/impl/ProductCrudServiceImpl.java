package ua.com.alevel.service.crud.product.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.alevel.data.datatable.DataTableRequest;
import ua.com.alevel.persistence.sql.entity.product.Product;
import ua.com.alevel.persistence.sql.repository.product.ProductRepository;
import ua.com.alevel.service.crud.product.ProductCrudService;

@Service
@Transactional
public class ProductCrudServiceImpl implements ProductCrudService {

    private final ProductRepository productRepository;

    public ProductCrudServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void create(Product entity) {
        productRepository.save(entity);
    }

    @Override
    public void update(Product entity) {
        checkExists(entity.getId());
        productRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        checkExists(id);
        productRepository.deleteById(id);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Page<Product> findAll(DataTableRequest request) {
        Sort sort = request.getSort().equals("desc")
                ? Sort.by(request.getOrder()).descending()
                : Sort.by(request.getOrder()).ascending();
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize(), sort);
        return productRepository.findAll(pageable);
    }

    private void checkExists(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }
    }
}
