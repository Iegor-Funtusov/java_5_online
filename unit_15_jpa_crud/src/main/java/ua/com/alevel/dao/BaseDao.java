package ua.com.alevel.dao;

import ua.com.alevel.datatable.DataTableRequest;
import ua.com.alevel.datatable.DataTableResponse;
import ua.com.alevel.entity.BaseEntity;

import java.util.Optional;

public interface BaseDao<E extends BaseEntity> {

    void create(E e);
    void update(E e);
    void delete(E e);
    boolean existsById(Long id);
    Optional<E> findById(Long id);
    DataTableResponse<E> findAll(DataTableRequest request);
}
