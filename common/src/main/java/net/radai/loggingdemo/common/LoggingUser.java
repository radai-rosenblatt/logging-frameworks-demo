package net.radai.loggingdemo.common;

import java.util.Locale;

/**
 * the test interface used to invoke logging calls
 * implementations are expected to be discoverable via
 * ServiceLoader for convenience.
 */
public interface LoggingUser {

    /**
     * make the implementation print something 
     * to its logging framework of choice 
     */
    void logSomething();

    /**
     * @return a particular implementation's name
     */
    default String name() {
        String lowercased = getClass().getSimpleName().toLowerCase(Locale.ROOT);
        if (lowercased.endsWith("user")) {
            lowercased = lowercased.substring(0, lowercased.indexOf("user"));
        }
        return lowercased;
    }
}
