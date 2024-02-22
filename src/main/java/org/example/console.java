package org.example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class console {
    private static final Logger logger = LoggerFactory.getLogger("OTHER");
    @GetMapping(value = "/console")
    public void doGetConsoleLog() {
        logger.info("hello world");
        logger.debug("debug world");
        logger.warn("warn world");
        logger.error("error world");
    }

}