package org.example;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class MyApp {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MyApp.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}