package ua.com.alevel.jdbc.config;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import ua.com.alevel.jdbc.util.EntityUtil;
import ua.com.alevel.properties.PropertiesStorage;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JdbcInitializer {

    private final Set<Class<?>> entitySet;
    private final Set<TableInfo> tableInfoSet = new HashSet<>();
    private Connection connection;
    private Statement statement;

    public JdbcInitializer(final Set<Class<?>> entitySet) {
        this.entitySet = entitySet;
    }

    public void init() {
        initTableState();
        initDriver();
        initTables();
    }

    private void initDriver() {
        try {
            Class.forName(PropertiesStorage.getInstance().getJpaDatasourceDriverClassName());
            this.connection = DriverManager.getConnection(
                    PropertiesStorage.getInstance().getJpaDatasourceUrl(),
                    PropertiesStorage.getInstance().getJpaDatasourceUrl(),
                    PropertiesStorage.getInstance().getJpaDatasourcePassword());
            this.statement = connection.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("failed init jdbc: " + e.getMessage());
        }
    }

    private void initTableState() {
        for (Class<?> entity : entitySet) {
            String tableName = EntityUtil.getTableNameByEntity(entity);
            Set<ColumnInfo> columnInfos = getColumnInfoSetByEntity(entity);
            tableInfoSet.add(new TableInfo(tableName, columnInfos));
        }
        tableInfoSet.forEach(System.out::println);
    }

    private Set<ColumnInfo> getColumnInfoSetByEntity(Class<?> entity) {
        final Set<ColumnInfo> columnInfoSet = new HashSet<>();
        List<Field> fields = FieldUtils.getAllFieldsList(entity);
        if (CollectionUtils.isNotEmpty(fields)) {
            fields.forEach(field -> {
                ColumnInfo columnInfo;
//                System.out.println("field = " + field);
                if (field.isAnnotationPresent(Id.class)) {
                    columnInfo = getColumnInfoIfFieldIsId(field);
                } else {
                    if (field.isAnnotationPresent(Column.class)) {
                        columnInfo = getColumnInfoByColumnAnnotation(field);
                    } else {
                        columnInfo = getColumnInfoByField(field);
                    }
                }
                columnInfoSet.add(columnInfo);
            });
        }
        return columnInfoSet;
    }

    private ColumnInfo getColumnInfoIfFieldIsId(Field field) {
        ColumnInfo columnInfo = new ColumnInfo();
        columnInfo.setIdColumn(true);
        if (field.isAnnotationPresent(GeneratedValue.class)) {
            GeneratedValue generatedValue = field.getAnnotation(GeneratedValue.class);
            GenerationType generationType = generatedValue.strategy();
            columnInfo.setGenerationType(generationType);
        }
        String columnName = EntityUtil.getColumnNameByField(field);
        columnInfo.setColumnName(columnName);
        return columnInfo;
    }

    private ColumnInfo getColumnInfoByColumnAnnotation(Field field) {
        ColumnInfo columnInfo = new ColumnInfo();
        String columnName = EntityUtil.getColumnNameByField(field);
        Column column = field.getAnnotation(Column.class);
        columnInfo.setColumnName(columnName);
        columnInfo.setUpdatable(column.updatable());
        columnInfo.setUnique(column.unique());
        columnInfo.setColumnDefinition(column.columnDefinition());
        columnInfo.setLength(column.length());
        columnInfo.setNullable(column.nullable());
        return columnInfo;
    }

    private ColumnInfo getColumnInfoByField(Field field) {
        ColumnInfo columnInfo = new ColumnInfo();
        String columnName = EntityUtil.getColumnNameByField(field);
        columnInfo.setColumnName(columnName);
        return columnInfo;
    }

    private void initTables() {
        if (JdbcDriver.MY_SQL.getDriverName().equals(PropertiesStorage.getInstance().getJpaDatasourceDriverClassName())) {
        }
        if (JdbcDriver.POSTGRESQL.getDriverName().equals(PropertiesStorage.getInstance().getJpaDatasourceDriverClassName())) {
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }

    private static class TableInfo {
        private String tableName;
        private Set<ColumnInfo> columnInfoSet = new HashSet<>();

        public TableInfo() {}

        public TableInfo(String tableName, Set<ColumnInfo> columnInfoSet) {
            this.tableName = tableName;
            this.columnInfoSet = columnInfoSet;
        }

        public String getTableName() {
            return tableName;
        }

        public void setTableName(String tableName) {
            this.tableName = tableName;
        }

        public void addColumnInfo(ColumnInfo columnInfo) {
            columnInfoSet.add(columnInfo);
        }

        public Set<ColumnInfo> getColumnInfoSet() {
            return columnInfoSet;
        }

        @Override
        public String toString() {
            return "TableInfo{" +
                    "tableName='" + tableName + '\'' +
                    ", columnInfoSet=" + columnInfoSet +
                    '}';
        }
    }

    private static class ColumnInfo {
        private String columnName;
        private boolean idColumn;
        private GenerationType generationType;
        private boolean unique;
        private boolean nullable;
        private boolean updatable;
        private String columnDefinition;
        private int length;

        public ColumnInfo() {
            this.generationType = GenerationType.AUTO;
            this.columnDefinition = "";
            this.nullable = true;
            this.updatable = true;
        }

        public String getColumnName() {
            return columnName;
        }

        public void setColumnName(String columnName) {
            this.columnName = columnName;
        }

        public boolean isIdColumn() {
            return idColumn;
        }

        public void setIdColumn(boolean idColumn) {
            this.idColumn = idColumn;
        }

        public GenerationType getGenerationType() {
            return generationType;
        }

        public void setGenerationType(GenerationType generationType) {
            this.generationType = generationType;
        }

        public boolean isUnique() {
            return unique;
        }

        public void setUnique(boolean unique) {
            this.unique = unique;
        }

        public boolean isNullable() {
            return nullable;
        }

        public void setNullable(boolean nullable) {
            this.nullable = nullable;
        }

        public boolean isUpdatable() {
            return updatable;
        }

        public void setUpdatable(boolean updatable) {
            this.updatable = updatable;
        }

        public String getColumnDefinition() {
            return columnDefinition;
        }

        public void setColumnDefinition(String columnDefinition) {
            this.columnDefinition = columnDefinition;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        @Override
        public String toString() {
            return "ColumnInfo{" +
                    "columnName='" + columnName + '\'' +
                    ", idColumn=" + idColumn +
                    ", generationType=" + generationType +
                    ", unique=" + unique +
                    ", nullable=" + nullable +
                    ", updatable=" + updatable +
                    ", columnDefinition='" + columnDefinition + '\'' +
                    ", length=" + length +
                    '}';
        }
    }
}
