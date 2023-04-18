package ua.com.alevel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Unit15JpaCrudApplication {

    @Autowired
    private CrudTestService crudTestService;

    public static void main(String[] args) {
        SpringApplication.run(Unit15JpaCrudApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void crudTest() {
        crudTestService.test();
    }
}
