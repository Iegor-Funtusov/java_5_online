package ua.com.alevel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class PowerlaptopServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PowerlaptopServerApplication.class, args);
    }
}
