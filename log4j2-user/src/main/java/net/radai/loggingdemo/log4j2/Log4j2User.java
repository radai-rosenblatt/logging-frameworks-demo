package net.radai.loggingdemo.log4j2;

import net.radai.loggingdemo.common.LoggingUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2User implements LoggingUser {
    private static final Logger logger = LogManager.getLogger(Log4j2User.class);

    @Override
    public void logSomething() {
        logger.info("logged to " + name());
    }
}
