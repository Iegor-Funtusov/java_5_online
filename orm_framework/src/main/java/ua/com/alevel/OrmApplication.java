package ua.com.alevel;

import org.reflections.Reflections;
import org.reflections.Store;
import ua.com.alevel.annotations.Column;
import ua.com.alevel.annotations.Entity;
import ua.com.alevel.annotations.Id;
import ua.com.alevel.annotations.Table;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class OrmApplication {

    public static void init(Class<?> mainClass) {
        Package packageClass = mainClass.getPackage();
        System.out.println("packageClass = " + packageClass);
        Reflections scanner = new Reflections(mainClass.getPackageName());
        Store store = scanner.getStore();
//        System.out.println("store = " + store);
        Collection<Map<String, Set<String>>> allClassCollection = store.values();
        allClassCollection.forEach(mapa -> {
//            System.out.println("mapa = " + mapa);
            Set<String> keys = mapa.keySet();
            keys.forEach(key -> {
//                System.out.println("key = " + key);
                if (key.equals(Entity.class.getName())) {
//                    System.out.println("key = " + key);
                    Set<String> classesEntity = mapa.get(key);
//                    System.out.println("classesEntity = " + classesEntity);
                    classesEntity.forEach(entityClass -> {
                        try {
                            Class<?> entity = Class.forName(entityClass);
//                            System.out.println("entity = " + entity);
                            if (entity.isAnnotationPresent(Table.class)) {
                                System.out.println("entity = " + entity);
                                Table table = entity.getAnnotation(Table.class);
                                String name = table.name();
                                System.out.println("name = " + name);
                                StringBuilder stringBuilder = new StringBuilder("create table " + name + "(");
                                Field[] fields = entity.getDeclaredFields();
                                for (Field field : fields) {
                                    System.out.println("field = " + field.getName());
                                    if (field.isAnnotationPresent(Id.class)) {
                                        stringBuilder.append("id bigint auto_increment primary key, ");
                                    }
                                    if (field.isAnnotationPresent(Column.class)) {
                                        Column column = field.getAnnotation(Column.class);
                                        String colName = column.name();
                                        if (field.getType().isAssignableFrom(String.class)) {
                                            stringBuilder.append(colName + " varchar(45),");
                                        }
                                        if (field.getType().isAssignableFrom(Integer.class)) {
                                            stringBuilder.append(colName + " int,");
                                        }
                                    } else {
                                        String colName = field.getName();
                                        if (field.getType().isAssignableFrom(String.class)) {
                                            stringBuilder.append(colName + " varchar(45),");
                                        }
                                        if (field.getType().isAssignableFrom(Integer.class)) {
                                            stringBuilder.append(colName + " int,");
                                        }
                                    }
                                }
                                stringBuilder.append(");");
                                System.out.println("stringBuilder = " + stringBuilder.toString());
                            }
                        } catch (ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    });

                }
            });
        });
    }
}
