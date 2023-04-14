package ua.com.alevel.datatable;

import ua.com.alevel.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public class DataTableResponse<E extends BaseEntity> {

    private int page;
    private int size;
    private String orderBy;
    private String sortBy;
    private int totalPages;
    private long totalItems;
    private List<E> items;

    public DataTableResponse() {
        this.items = new ArrayList<>();
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
    }

    public List<E> getItems() {
        return items;
    }

    public void setItems(List<E> items) {
        this.items = items;
    }
}
