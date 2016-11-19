package chain;

import java.util.regex.Pattern;

/**
 * Created by Марат on 15.11.2016.
 */
public class InfoLogger extends Logger {
    public InfoLogger() {
        pattern = Pattern.compile("^\\[(INFO|ERROR)\\] : \\[.*\\]$");
    }
}
