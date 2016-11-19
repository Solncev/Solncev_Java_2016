package chain;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by Марат on 15.11.2016.
 */
public abstract class Logger {

    private static final String EMPTY_STRING = "";
    private static final String OR = "|";

    private Pattern pattern;

    private Logger next;


    Logger(Level... level) {
        generatePattern(level);
    }

    public void setNext(Logger nextLogger) {
        this.next = nextLogger;
    }

    public void log(String message) {
        if (isMessageCorrect(message, pattern)) {
            String text = message.substring(message.indexOf('[', 2), message.length());
            System.out.println(text);
        }
        if (next != null) {
            next.log(message);
        }
    }

    private boolean isMessageCorrect(String message, Pattern pattern) {
        return pattern.matcher(message).matches();
    }

    private void generatePattern(Level... level) {
        String pLevel = Arrays.stream(level).map(Enum::toString)
                .collect(Collectors.toList())
                .stream()
                .reduce((s, s2) -> s + '|' + s2).get();
        pattern = Pattern.compile("^\\[(" + pLevel + ")\\] : \\[.*\\]$");
    }
}
