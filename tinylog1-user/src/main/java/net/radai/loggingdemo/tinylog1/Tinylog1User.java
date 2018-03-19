package net.radai.loggingdemo.tinylog1;

import net.radai.loggingdemo.common.LoggingUser;
import org.pmw.tinylog.Logger;

public class Tinylog1User implements LoggingUser {
    @Override
    public void logSomething() {
        Logger.info("logged to " + name());
    }
}
