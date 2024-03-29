package ua.com.alevel.datatable;

public class DataTableRequest {

    private int page;
    private int size;
    private String orderBy;
    private String sortBy;

    public DataTableRequest() {
        this.orderBy = "desc";
        this.sortBy = "id";
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
}
