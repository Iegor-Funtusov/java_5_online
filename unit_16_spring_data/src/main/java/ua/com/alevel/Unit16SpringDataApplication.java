package ua.com.alevel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import ua.com.alevel.persistence.CrudTestService;

@SpringBootApplication
public class Unit16SpringDataApplication {

    private final CrudTestService crudTestService;

    public Unit16SpringDataApplication(CrudTestService crudTestService) {
        this.crudTestService = crudTestService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Unit16SpringDataApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void crudTest() {
        crudTestService.test();
    }
}
