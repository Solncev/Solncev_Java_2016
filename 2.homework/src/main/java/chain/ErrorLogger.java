package chain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Марат on 15.11.2016.
 */
public class ErrorLogger extends Logger {
    public ErrorLogger() {
        level = Level.ERROR;
    }

    @Override
    protected boolean isCorrect(String message) {
        Pattern p = Pattern.compile("^\\[ERROR\\] : \\[.*\\]$");
        Matcher m = p.matcher(message);
        return m.matches();
    }
}
