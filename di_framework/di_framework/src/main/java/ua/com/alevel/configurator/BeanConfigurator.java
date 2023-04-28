package ua.com.alevel.configurator;

import java.util.Map;

public interface BeanConfigurator {

    void configure(final Object bean, final Map<Class<?>, Object> beanMap);
}
