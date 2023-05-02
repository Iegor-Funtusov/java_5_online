package ua.com.alevel;

import ua.com.alevel.controller.ApplicationController;
import ua.com.alevel.controller.impl.ConsoleController;
import ua.com.alevel.factory.BeanFactory;
import ua.com.alevel.factory.DataFactory;
import ua.com.alevel.factory.EntityFactory;
import ua.com.alevel.jdbc.config.JdbcInitializer;
import ua.com.alevel.properties.PropertiesStorage;

public class DiApplication {

    public static void start(Class<?> mainClass, String[] args) {
        ApplicationConfiguration configuration = new ApplicationConfiguration(mainClass);
        PropertiesStorage.getInstance().init(mainClass.getClassLoader());
        BeanFactory beanFactory = new BeanFactory(configuration.getStore());
        beanFactory.initBeans();
        configuration.beanConfigure(beanFactory.getBeanMap());
        DataFactory dataFactory = new DataFactory(configuration.getStore());
        dataFactory.initData();
//        EntityFactory entityFactory = new EntityFactory(configuration.getStore());
//        entityFactory.initEntities();
//        JdbcInitializer jdbcInitializer = new JdbcInitializer(entityFactory.getEntitySet());
//        jdbcInitializer.init();
        ApplicationController controller = new ConsoleController(beanFactory.getBeanMap(), dataFactory.getDataSet());
        controller.start();
    }
}
