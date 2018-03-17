package net.radai.loggingdemo.common;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * finds all LoggingUsers on the classpath and exercises them
 */
public class Exerciser {
    public static List<String> exercise() {
        ServiceLoader<LoggingUser> userLoader = ServiceLoader.load(LoggingUser.class);
        List<String> names = new ArrayList<>();
        for (LoggingUser user : userLoader) {
            names.add(user.name());
            user.logSomething();
        }
        return names;
    }
}
