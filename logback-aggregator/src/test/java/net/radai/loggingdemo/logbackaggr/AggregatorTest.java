package net.radai.loggingdemo.logbackaggr;

import net.radai.loggingdemo.common.Exerciser;
import net.radai.loggingdemo.common.RecordingPrintStream;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.bridge.SLF4JBridgeHandler;

import java.util.List;

public class AggregatorTest {
    
    @Before
    public void setup() {
        //unfortunately required to redirect jul --> logback. 
        //see https://www.slf4j.org/api/org/slf4j/bridge/SLF4JBridgeHandler.html 
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
    }
    
    @Test
    public void testSomething() throws Exception {
        RecordingPrintStream recordingOut = new RecordingPrintStream(System.out);
        System.setOut(recordingOut);
        List<String> fwkNames = Exerciser.exercise();
        String recording = recordingOut.getRecording();
        String ofChoice = "logback";
        for (String fwk : fwkNames) {
            String marker = String.format("logged to %s - delivered to %s", fwk, ofChoice);
            Assert.assertTrue(fwk + " was not properly redirected", recording.contains(marker));
        }
    }

}
