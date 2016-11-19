package chain;

import java.util.regex.Pattern;

/**
 * Created by Марат on 15.11.2016.
 */
public class ErrorLogger extends Logger {
    public ErrorLogger() {
        pattern = Pattern.compile("^\\[ERROR\\] : \\[.*\\]$");
    }
}
