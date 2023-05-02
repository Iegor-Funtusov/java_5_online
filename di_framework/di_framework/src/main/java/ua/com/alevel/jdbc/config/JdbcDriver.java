package ua.com.alevel.jdbc.config;

public enum JdbcDriver {

    MY_SQL("com.mysql.cj.jdbc.Driver"),
    POSTGRESQL("org.postgresql.Driver");

    private final String driverName;

    JdbcDriver(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverName() {
        return driverName;
    }
}
