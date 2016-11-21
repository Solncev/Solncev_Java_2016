package chain;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by Марат on 15.11.2016.
 */
public abstract class Logger {

    private Logger nextLogger;
    private Pattern pattern;

    Logger(Level... level) {
        generatePattern(level);
    }

    public void setNext(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    private void generatePattern(Level... level) {
        String pLevel = Arrays.stream(level).map(Enum::toString)
                .collect(Collectors.toList())
                .stream()
                .reduce((s, s2) -> s + '|' + s2).get();
        pattern = Pattern.compile("^\\[(" + pLevel + ")\\] : \\[.*\\]$");

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
