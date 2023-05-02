package ua.com.alevel.properties;

import ua.com.alevel.util.ResourcesUtil;

import java.util.HashMap;
import java.util.Map;

import static ua.com.alevel.properties.PropertiesConfig.*;

public final class PropertiesStorage {

    private final static PropertiesStorage instance = new PropertiesStorage();
    private final Map<String, String> properties = new HashMap<>();

    private String jpaStrategy;
    private String jpaShowSql;
    private String jpaDatasourceDriverClassName;
    private String jpaDatasourceUrl;
    private String jpaDatasourceUsername;
    private String jpaDatasourcePassword;

    private PropertiesStorage() {}

    public static PropertiesStorage getInstance() {
        return instance;
    }

    public void init(ClassLoader appLoader) {
        this.properties.putAll(ResourcesUtil.getProperties(appLoader));
        this.jpaStrategy = this.properties.get(JPA_STRATEGY.getProperties());
        this.jpaShowSql = this.properties.get(JPA_SHOW_SQL.getProperties());
        this.jpaDatasourceDriverClassName = this.properties.get(JPA_DATASOURCE_DRIVER_CLASS_NAME.getProperties());
        this.jpaDatasourceUrl = this.properties.get(JPA_DATASOURCE_URL.getProperties());
        this.jpaDatasourceUsername = this.properties.get(JPA_DATASOURCE_USERNAME.getProperties());
        this.jpaDatasourcePassword = this.properties.get(JPA_DATASOURCE_PASSWORD.getProperties());
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public String getJpaStrategy() {
        return jpaStrategy;
    }

    public String getJpaShowSql() {
        return jpaShowSql;
    }

    public String getJpaDatasourceDriverClassName() {
        return jpaDatasourceDriverClassName;
    }

    public String getJpaDatasourceUrl() {
        return jpaDatasourceUrl;
    }

    public String getJpaDatasourceUsername() {
        return jpaDatasourceUsername;
    }

    public String getJpaDatasourcePassword() {
        return jpaDatasourcePassword;
    }
}
