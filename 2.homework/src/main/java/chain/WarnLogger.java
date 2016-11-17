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
    public void log(String message) {
        if (isCorrect(message)) {
            String[] s = message.split(" : ");
            String text = s[1];
            write(text);
        }
        if (nextLogger != null) {
            nextLogger.log(message);
        }
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
