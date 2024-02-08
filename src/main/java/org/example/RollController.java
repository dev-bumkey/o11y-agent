package org.example;

import org.slf4j.*;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.*;
import java.util.logging.SimpleFormatter;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class RollController {
    private static final Logger logger = LoggerFactory.getLogger(RollController.class);
    private static final java.util.logging.Logger logger2 = java.util.logging.Logger.getLogger("BkLooker");

    @GetMapping("/rolldice")
    public String index(@RequestParam("player") Optional<String> player) {
        int result = this.getRandomNumber(1, 6);
        if (player.isPresent()) {
            logger.info("{} is rolling the dice: {}", player.get(), result);
        } else {
            logger.info("Anonymous player is rolling the dice: {}", result);
        }
        return Integer.toString(result);
    }

    @GetMapping(value = "/log")
    public void doGetHelloWorldLog() {
        logger.info("hello world");
        logger.debug("debug world");
        logger.warn("warn world");
        logger.error("error world");
    }

    @GetMapping(value = "/")
    public String doPostFileLog() {
        // Level : OFF, SEVERE, WARNING, INFO, CONFIG, FINE, FINER, FINEST, ALL

        logger2.setLevel(Level.ALL);



        FileHandler fh;

        try {

            // new FileHandler(String pattern, int limit (파일크기제한), int count(파일개수제한), boolean append(이어쓰기));
            // %g  The generation number that distinguishes the rotated log files from each other.

            fh = new FileHandler("/var/log/MyLog%g.log", 200, 1000, true);

            fh.setLevel(Level.ALL);



            logger2.addHandler(fh);



            // XML Formatter

            SimpleFormatter formatter = new SimpleFormatter();

            fh.setFormatter(formatter);



            logger2.info("============== START =================");

            for (int i=0; i<30; i++) {

                logger2.info(String.format("Log - info %d", i));

                logger2.warning(String.format("Log - warning %d", i));

                logger2.severe(String.format("Log - severe %d", i));

                Thread.sleep(2000);

            }

        } catch (SecurityException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        logger2.info("============== END =================");

        return "file Log Fin";
    }


    public int getRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}