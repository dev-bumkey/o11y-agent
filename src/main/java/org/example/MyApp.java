package org.example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class MyApp {
    private final Logger log = LoggerFactory.getLogger(getClass());
    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }

    @GetMapping(value = "/")
    public String doGetHelloWorld() {
        return "Hello World";
    }

    @GetMapping(value = "/demo")
    public String doGetHelloWorldDemo() {
        return "Hello World (Demo)";
    }

    @GetMapping(value = "/log")
    public void doGetHelloWorldLog() {
        log.info("hello world");
        log.debug("debug world");
        log.warn("warn world");
        log.error("error world");
    }
}