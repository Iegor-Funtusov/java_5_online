package ua.com.alevel.service;

import java.sql.Connection;
import java.sql.Statement;

public interface JdbcService {

    Connection getConnection();
    Statement getStatement();
}
