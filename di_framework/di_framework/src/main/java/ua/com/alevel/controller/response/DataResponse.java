package ua.com.alevel.controller.response;

public class DataResponse<DATA> {

    private DATA data;

    public DataResponse() {}

    public DataResponse(DATA data) {
        this.data = data;
    }

    public DATA getData() {
        return data;
    }

    public void setData(DATA data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataResponse{" +
                "data=" + data +
                '}';
    }
}
