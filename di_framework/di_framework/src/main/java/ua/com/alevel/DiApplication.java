package ua.com.alevel;

import ua.com.alevel.factory.BeanFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DiApplication {

    public static void start(Class<?> mainClass, String[] args, Class<?> starterClass) {
        ApplicationConfiguration configuration = new ApplicationConfiguration(mainClass);
        BeanFactory beanFactory = new BeanFactory(configuration.getStore());
        beanFactory.initBeans();
        configuration.beanConfigure(beanFactory.getBeanMap());

        for (Method declaredMethod : starterClass.getDeclaredMethods()) {
//            System.out.println("declaredMethod = " + declaredMethod.getName());
            if (declaredMethod.getName().equals("start")) {
                Object mainController = beanFactory.getBeanMap().get(starterClass);
                if (mainController != null) {
                    try {
                        declaredMethod.invoke(mainController);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
