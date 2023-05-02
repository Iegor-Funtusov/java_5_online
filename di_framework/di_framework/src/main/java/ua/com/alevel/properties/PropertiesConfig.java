package ua.com.alevel.properties;

public enum PropertiesConfig {

    APPLICATION_PROPERTIES("application.properties"),
    JPA_STRATEGY("di.jpa.strategy"),
    JPA_SHOW_SQL("di.jpa.show-sql"),
    JPA_DATASOURCE_DRIVER_CLASS_NAME("di.jpa.datasource.driver-class-name"),
    JPA_DATASOURCE_URL("di.jpa.datasource.url"),
    JPA_DATASOURCE_USERNAME("di.jpa.datasource.username"),
    JPA_DATASOURCE_PASSWORD("di.jpa.datasource.password");

    PropertiesConfig(String properties) {
        this.properties = properties;
    }

    private final String properties;

    public String getProperties() {
        return properties;
    }
}
