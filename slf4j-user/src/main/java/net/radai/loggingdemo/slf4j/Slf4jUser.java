package net.radai.loggingdemo.slf4j;

import net.radai.loggingdemo.common.LoggingUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jUser implements LoggingUser {
    private static final Logger logger = LoggerFactory.getLogger(Slf4jUser.class);

    @Override
    public void logSomething() {
        logger.info("logged to " + name());
    }
}
