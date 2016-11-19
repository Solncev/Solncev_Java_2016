package chain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Марат on 15.11.2016.
 */
public class InfoLogger extends Logger {
    public InfoLogger() {
        level = Level.INFO;
    }

    @Override
    protected boolean isCorrect(String message) {
        Pattern p = Pattern.compile("^\\[(INFO|ERROR)\\] : \\[.*\\]$");
        Matcher m = p.matcher(message);
        return m.matches();
    }

    protected void write(String message) {
        System.out.println(message);
    }
}
