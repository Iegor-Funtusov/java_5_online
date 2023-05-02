package ua.com.alevel.controller.util;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public final class MethodParameterUtil {

    private MethodParameterUtil() { }

    public static Object initializeParameterFields(final BufferedReader bf, Class<?> methodParam)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException {
        Object fieldObject = methodParam.getDeclaredConstructor().newInstance();
        Field[] fields = methodParam.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field = " + field.getName());
            System.out.println("Please enter a " + field.getName());
            String fieldValue = bf.readLine();
            System.out.println("fieldValue = " + fieldValue);
            if (field.getType().isAssignableFrom(String.class)) {
                field.setAccessible(true);
                field.set(fieldObject, fieldValue);
            }
            if (field.getType().isAssignableFrom(Integer.class)) {
                field.setAccessible(true);
                field.set(fieldObject, Integer.parseInt(fieldValue));
            }
            if (field.getType().isAssignableFrom(Long.class)) {
                field.setAccessible(true);
                field.set(fieldObject, Long.parseLong(fieldValue));
            }
        }
        return fieldObject;
    }

    public static Object initializeParameterField(final BufferedReader bf, Class<?> methodParam) throws IOException {
        System.out.println("Please enter a param: " + methodParam.getName());
        String paramValue = bf.readLine();
        System.out.println("paramValue = " + paramValue);
        if (StringUtils.isNumericSpace(paramValue)) {
            if (methodParam.isAssignableFrom(Integer.class)) {
                return Integer.parseInt(paramValue);
            }
            if (methodParam.isAssignableFrom(Long.class)) {
                return Long.parseLong(paramValue);
            }
        }
        if (methodParam.isAssignableFrom(String.class)) {
            return paramValue;
        }
        return null;
    }
}
