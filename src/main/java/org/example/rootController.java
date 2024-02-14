package org.example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class rootController {
    private static final Logger logger = LoggerFactory.getLogger("CONSOLE");

    @GetMapping("/")
    public String index(@RequestParam("player") Optional<String> player) {
        int result = this.getRandomNumber(1, 6);
        if (player.isPresent()) {
            logger.info("!!!!!{} is rolling the dice: {}", player.get(), result);
        } else {
            logger.info("!!!!!Anonymous player is rolling the dice: {}", result);
        }
        return Integer.toString(result);
    }
    @GetMapping("/1")
    public void doGetFileLog() {
        logger.info("sidecar info");
        logger.debug("sidecar debug");
        logger.warn("sidecar setting");
        logger.error("complete");
    }

    public int getRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}