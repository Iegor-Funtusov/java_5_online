package ua.com.alevel.configurator.impl;

import ua.com.alevel.annotations.Inject;
import ua.com.alevel.configurator.BeanConfigurator;

import java.lang.reflect.Field;
import java.util.Map;

public class InjectAnnotationBeanConfigurator implements BeanConfigurator {

    @Override
    public void configure(Object bean, Map<Class<?>, Object> beanMap) {
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Inject.class)) {
                Object injectedBean = beanMap.get(field.getType());
                if (injectedBean != null) {
                    field.setAccessible(true);
                    try {
                        field.set(bean, injectedBean);
                    } catch (IllegalAccessException e) {
                        System.out.println("error inject bean " + e.getMessage());
                    }
                }
            }
        }
    }
}
