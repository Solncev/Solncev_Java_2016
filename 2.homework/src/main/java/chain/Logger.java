package chain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Марат on 15.11.2016.
 */
public abstract class Logger {
    protected Level level;
    protected Pattern pattern;

    protected Logger nextLogger;

    public void setNext(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void log(String message) {
        if (isCorrect(message, pattern)) {
            String text = message.substring(message.indexOf('[', 2), message.length());
            System.out.println(text);
        }
        if (nextLogger != null) {
            nextLogger.log(message);
        }
    }

    protected boolean isCorrect(String message, Pattern pattern) {
        Matcher m = pattern.matcher(message);
        return m.matches();
    }
}
