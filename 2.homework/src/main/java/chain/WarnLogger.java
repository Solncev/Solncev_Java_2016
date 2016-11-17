package chain;

/**
 * Created by Марат on 15.11.2016.
 */
public class WarnLogger extends Logger {
    public WarnLogger() {
        this.level = "WARN";
    }

    @Override
    public void log(String message) {
        if (this.level.equals(getLevel(message))) {
            String[] s = message.split(" : ");
            String text = s[1];
            write(text);

        }
        if (nextLogger != null) {
            nextLogger.log(message);
        }
    }

    protected void write(String message) {
        System.out.println(message);
    }
}
