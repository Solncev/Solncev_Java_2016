package chain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Марат on 15.11.2016.
 */
public class WarnLogger extends Logger {
    public WarnLogger() {
        level = Level.WARN;
    }

    @Override
    protected boolean isCorrect(String message) {
        Pattern p = Pattern.compile("^\\[WARN\\] : \\[.*\\]$");
        Matcher m = p.matcher(message);
        return m.matches();
    }

    protected void write(String message) {
        System.out.println(message);
    }
}
