package ua.com.alevel.datatable;

import lombok.Getter;
import lombok.Setter;
import ua.com.alevel.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DataTableResponse<E extends BaseEntity> {

    private int page;
    private int size;
    private String orderBy;
    private String sortBy;
    private int totalPages;
    private long totalItems;
    private List<E> items;
}
