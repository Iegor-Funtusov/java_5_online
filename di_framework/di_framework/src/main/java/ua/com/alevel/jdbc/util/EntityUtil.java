package ua.com.alevel.jdbc.util;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.util.AppStringUtil;

import java.lang.reflect.Field;

public final class EntityUtil {

    private EntityUtil() { }

    public static String getTableNameByEntity(Class<?> entity) {
        String tableName = null;
        Table tableAnnotation = entity.getAnnotation(Table.class);
        if (tableAnnotation != null) {
            tableName = tableAnnotation.name();
            if (StringUtils.isNotBlank(tableName)) {
                return tableName;
            }
        }
        if (StringUtils.isBlank(tableName)) {
            tableName = entity.getSimpleName().toLowerCase() + "s";
        }
        return tableName;
    }

    public static String getColumnNameByField(Field field) {
        String columnName;
        if (field.isAnnotationPresent(Column.class)) {
            Column column = field.getAnnotation(Column.class);
            String name = column.name();
            if (StringUtils.isNotBlank(name)) {
                columnName = name;
            } else {
                columnName = AppStringUtil.convertCamelCaseStyleToSnakeCase(field.getName());
            }
        } else {
            columnName = AppStringUtil.convertCamelCaseStyleToSnakeCase(field.getName());
        }
        return columnName;
    }
}
