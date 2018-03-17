package net.radai.loggingdemo.log4j2aggr;

import net.radai.loggingdemo.common.Exerciser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class AggregatorTest {
    
    @Before
    public void setup() {
        //unfortunately required to redirect jul --> log4j2. 
        //see https://logging.apache.org/log4j/2.0/log4j-jul/index.html
        //NOTE - when running under gradle this is too late because
        //gradle has already initialized the jul system at this point
        //there's a repeat of this in build.gradle for this reason
        System.setProperty("java.util.logging.manager", "org.apache.logging.log4j.jul.LogManager");
    }
    
    @Test
    public void testSomething() throws Exception {
        
        //install our own appender under the log4j2 root logger
        LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
        Configuration config = ctx.getConfiguration();
        RecordingAppender appender = new RecordingAppender();
        config.getRootLogger().addAppender(appender, Level.ALL, null);
        
        List<String> fwkNames = Exerciser.exercise();
        String recording = appender.getRecording();
        for (String fwk : fwkNames) {
            String marker = String.format("logged to %s", fwk);
            Assert.assertTrue(fwk + " was not properly redirected", recording.contains(marker));
        }
    }
    
    private static class RecordingAppender extends AbstractAppender {
        StringBuilder recorder = new StringBuilder();
        
        public RecordingAppender() {
            super("recorder", null, null);
            start(); //see https://stackoverflow.com/questions/39228697/log4j2-custom-appender-error-attempted-to-append-to-non-started-appender
        }

        @Override
        public void append(LogEvent event) {
            String formatted = event.getMessage().getFormattedMessage();
            recorder.append(formatted).append("\n");
        }
        
        public String getRecording() {
            return recorder.toString();
        }
    }

}
