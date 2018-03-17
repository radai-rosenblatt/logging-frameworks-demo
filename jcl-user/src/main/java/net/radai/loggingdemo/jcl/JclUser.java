package net.radai.loggingdemo.jcl;

import net.radai.loggingdemo.common.LoggingUser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class JclUser implements LoggingUser {
    private final static Log logger = LogFactory.getLog(JclUser.class);

    @Override
    public void logSomething() {
        logger.info("logged to " + name());
    }
}
