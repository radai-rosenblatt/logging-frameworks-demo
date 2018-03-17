package net.radai.loggingdemo.log4j1;

import net.radai.loggingdemo.common.LoggingUser;
import org.apache.log4j.Logger;

public class Log4j1User implements LoggingUser {
    private static final Logger logger = Logger.getLogger(Log4j1User.class);

    @Override
    public void logSomething() {
        logger.info("logged to " + name());
    }
}
