package ua.com.alevel.datatable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataTableRequest {

    private int page;
    private int size;
    private String orderBy;
    private String sortBy;

    public DataTableRequest() {
        this.orderBy = "desc";
        this.sortBy = "id";
    }
}
