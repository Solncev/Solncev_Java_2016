package decorator;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by Марат on 16.11.2016.
 */
public class CaeserReader extends FilterReader {
    /**
     * Creates a new filtered reader.
     *
     * @param in a Reader object providing the underlying stream.
     * @throws NullPointerException if <code>in</code> is <code>null</code>
     */
    protected CaeserReader(Reader in) {
        super(in);
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        int result = super.read(cbuf, off, len);
        for (int i = off; i < off + result; i++) {
            cbuf[i] = (char) (Integer.valueOf(cbuf[i]) + 20);
        }
        return result;
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return c == -1 ? c : c + 20;
    }
}
