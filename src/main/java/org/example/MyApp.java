package org.example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;


@RestController
@SpringBootApplication
public class MyApp {

    private static final Logger logger = LoggerFactory.getLogger("FILE");
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MyApp.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            double r = Math.random();
            int intValue = (int) (r * 100) + 1;
            logger.info("Random Value: {}", intValue);
        }, 0, 30, TimeUnit.SECONDS); // 30초마다 실행

        // 어플리케이션이 종료될 때 스케줄러도 종료되도록 합니다.
        Runtime.getRuntime().addShutdownHook(new Thread(scheduler::shutdown));
    }
}