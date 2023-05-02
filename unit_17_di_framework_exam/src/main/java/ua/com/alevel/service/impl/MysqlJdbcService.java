package ua.com.alevel.service.impl;

import ua.com.alevel.annotations.Service;
import ua.com.alevel.annotations.Value;
import ua.com.alevel.service.JdbcService;

import java.sql.Connection;
import java.sql.Statement;

@Service
public class MysqlJdbcService implements JdbcService {

    @Value("datasource.driver-class-name")
    private String driver;

    @Value("datasource.url")
    private String url;

    @Value("datasource.username")
    private String username;

    @Value("datasource.password")
    private String password;

    private void init() {}

    @Override
    public Connection getConnection() {
        return null;
    }

    @Override
    public Statement getStatement() {
        return null;
    }
}
