package ua.com.alevel;

import org.apache.commons.collections4.CollectionUtils;
import org.reflections.Reflections;
import org.reflections.Store;
import ua.com.alevel.configurator.BeanConfigurator;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ApplicationConfiguration {

    private final Reflections scanner;
    private final Reflections frameworkScanner;

    public ApplicationConfiguration(Class<?> mainClass) {
        scanner = new Reflections(mainClass.getPackageName());
        frameworkScanner = new Reflections(this.getClass().getPackageName());
    }

    public void beanConfigure(final Map<Class<?>, Object> beanMap) {
        Set<Class<? extends BeanConfigurator>> subTypesOf = frameworkScanner.getSubTypesOf(BeanConfigurator.class);
        Set<? extends BeanConfigurator> configurators = subTypesOf
                .stream()
                .map(configurator -> {
                    try {
                        return configurator.getDeclaredConstructor().newInstance();
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toSet());
        if (CollectionUtils.isNotEmpty(configurators)) {
            configurators
                    .forEach(configurator -> beanMap
                            .forEach((beanClass, beanImpl) -> configurator.configure(beanImpl, beanMap)));
        }
    }

    public Store getStore() {
        return scanner.getStore();
    }
}
