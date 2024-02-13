package org.example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class file {
    private static final Logger logger = LoggerFactory.getLogger("FILE");
    @GetMapping(value = "/file")
    public void doGetFileLog() {
        logger.info("what is your name");
        logger.debug("my name is api");
        logger.warn("api HI");
        logger.error("Nice to meet you");
    }

}