package ua.com.alevel;

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
                    } catch (InstantiationException e) {
                        throw new RuntimeException(e);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException(e);
                    } catch (NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toSet());
        for (BeanConfigurator configurator : configurators) {
//            System.out.println("configurator = " + configurator.getClass().getName());
            beanMap.forEach((beanClass, beanImpl) -> {
                configurator.configure(beanImpl, beanMap);
            });
        }
    }

    public Store getStore() {
        return scanner.getStore();
    }
}
