package ua.com.alevel.factory;

import org.apache.commons.lang3.ArrayUtils;
import org.reflections.Store;
import org.reflections.scanners.Scanners;
import ua.com.alevel.annotations.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BeanFactory {

    private final Map<Class<?>, Object> beanMap = new HashMap<>();
    private final Store appStore;

    public BeanFactory(Store store) {
        appStore = store;
    }

    public void initBeans() {
        appStore.forEach((k, v) -> {
            if (k.equals(Scanners.TypesAnnotated.name())) {
                v.forEach((key, value) -> {
                    if (key.equals(Service.class.getName())) {
                        Set<String> beanClasses = value;
                        beanClasses.forEach(bean -> {
                            try {
//                                System.out.println("bean = " + bean);
                                Class<?> beanClass = Class.forName(bean);
                                if (!beanClass.isAnnotationPresent(Deprecated.class)) {
                                    Class<?>[] interfaces = beanClass.getInterfaces();
                                    if (ArrayUtils.isNotEmpty(interfaces)) {
                                        Class<?> beanKey = null;
                                        if (interfaces.length == 1) {
                                            beanKey = interfaces[0];
                                        } else {
                                            for (Class<?> anInterface : interfaces) {
                                                if (anInterface.getSimpleName().startsWith(beanClass.getSimpleName())) {
                                                    beanKey = anInterface;
                                                }
                                            }
                                        }
                                        Object createdBean = beanClass.getDeclaredConstructor().newInstance();
                                        beanMap.put(beanKey, createdBean);
                                    } else {
                                        Object createdBean = beanClass.getDeclaredConstructor().newInstance();
                                        beanMap.put(beanClass, createdBean);
                                    }
                                }
                            } catch (ClassNotFoundException e) {
                                System.out.println("error bean created: " + e.getMessage());
                            } catch (InvocationTargetException e) {
                                throw new RuntimeException(e);
                            } catch (InstantiationException e) {
                                throw new RuntimeException(e);
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(e);
                            } catch (NoSuchMethodException e) {
                                throw new RuntimeException(e);
                            }
                        });
//                        System.out.println("beanMap = " + beanMap);
                    }
                });
            }
        });
    }

    public Map<Class<?>, Object> getBeanMap() {
        return beanMap;
    }
}
