package chain;

import java.util.regex.Pattern;

/**
 * Created by Марат on 15.11.2016.
 */
public class WarnLogger extends Logger {
    public WarnLogger() {
        pattern = Pattern.compile("^\\[WARN\\] : \\[.*\\]$");
    }
}
