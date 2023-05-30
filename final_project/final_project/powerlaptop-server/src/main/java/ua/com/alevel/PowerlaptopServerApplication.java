package ua.com.alevel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@EnableScheduling
@SpringBootApplication
public class PowerlaptopServerApplication {

    @Autowired
    private PasswordEncoder encoder;

    public static void main(String[] args) {
        SpringApplication.run(PowerlaptopServerApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void run() {
        System.out.println("PowerlaptopServerApplication.run");

        String password = "12345";
        String hash = "$2a$10$2b4OLA.gCg8oLcENaIzqvOKWyb7mkFXcNjPN5OnmW8P4igAX8eY/i";
        String hash1 = "$2a$10$2b4OLA.gCg8oLcENaIzqvOKWyb7mkFXcNjPN5OnmW8P4igAX8eY/j";

        System.out.println("password = " + encoder.encode(password));
        System.out.println("password = " + encoder.encode(password));
        System.out.println("password = " + encoder.encode(password));
        System.out.println("password = " + encoder.encode(password));

        System.out.println();

        System.out.println("valid = " + encoder.matches(password, hash));
        System.out.println("valid = " + encoder.matches(password, hash1));
    }
}
