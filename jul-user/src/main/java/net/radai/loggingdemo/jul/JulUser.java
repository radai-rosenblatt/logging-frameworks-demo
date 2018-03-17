package net.radai.loggingdemo.jul;

import net.radai.loggingdemo.common.LoggingUser;

import java.util.logging.Logger;

public class JulUser implements LoggingUser {
    private final static Logger logger = Logger.getLogger(JulUser.class.getName());

    @Override
    public void logSomething() {
        logger.info("logged to " + name());
    }
}
