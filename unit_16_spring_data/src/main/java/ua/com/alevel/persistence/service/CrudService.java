package ua.com.alevel.persistence.service;

import org.springframework.data.domain.Page;
import ua.com.alevel.persistence.entity.BaseEntity;

import java.util.Optional;

public interface CrudService<E extends BaseEntity> {

    void create(E entity);
    void update(E entity);
    void delete(Long id);
    Page<E> findAll(int page, int size, String sortBy, String orderBy);
    Optional<E> findById(Long id);
}
