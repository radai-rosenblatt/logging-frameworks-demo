package net.radai.loggingdemo.common;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * an implementation of PrintStream that delegates to another stream while
 * recording everything being printed, in UTF-8.
 */
public class RecordingPrintStream extends PrintStream {
    private final PrintStream delegate;
    private final ByteArrayOutputStream recording;
    
    public RecordingPrintStream(PrintStream delegate) throws UnsupportedEncodingException {
        super(new ByteArrayOutputStream(), true, "UTF-8");
        this.recording = (ByteArrayOutputStream) out;
        this.delegate = delegate;
    }
    
    public String getRecording() {
        return new String(recording.toByteArray(), Charset.forName("UTF-8"));
    }

    @Override
    public void flush() {
        super.flush();
        delegate.flush();
    }

    @Override
    public void close() {
        super.flush();
        delegate.close();
    }

    @Override
    public boolean checkError() {
        return super.checkError() || delegate.checkError();
    }

    @Override
    public void write(int b) {
        super.write(b);
        delegate.write(b);
    }

    @Override
    public void write(byte[] buf, int off, int len) {
        super.write(buf, off, len);
        delegate.write(buf, off, len);
    }
}
