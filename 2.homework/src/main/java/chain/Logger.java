package chain;

import java.util.regex.Pattern;

/**
 * Created by Марат on 15.11.2016.
 */
public abstract class Logger {
    protected Pattern pattern;

    protected Logger nextLogger;

    public void setNext(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void log(String message) {
        if (isMessageCorrect(message)) {
            String text = message.substring(message.indexOf('[', 2), message.length());
            System.out.println(text);
        }
        if (nextLogger != null) {
            nextLogger.log(message);
        }
    }

    protected boolean isMessageCorrect(String message) {
        return pattern.matcher(message).matches();
    }
}
