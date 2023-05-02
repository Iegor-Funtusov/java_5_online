package ua.com.alevel.facade;

import ua.com.alevel.dto.BaseDto;
import ua.com.alevel.entity.BaseEntity;

import java.util.Collection;

public interface CrudFacade<DTO extends BaseDto, E extends BaseEntity> {

    void create(DTO dto);
    void update(DTO dto, Long id);
    void delete(Long id);
    E findById(Long id);
    Collection<E> findAll();
}
