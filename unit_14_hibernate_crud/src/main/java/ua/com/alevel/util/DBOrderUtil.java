package ua.com.alevel.util;

public enum DBOrderUtil {

    DESC("desc"),
    ASC("asc");

    private final String type;

    DBOrderUtil(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
