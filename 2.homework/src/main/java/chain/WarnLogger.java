package chain;

/**
 * Created by Марат on 15.11.2016.
 */
public class WarnLogger extends Logger {
    public WarnLogger() {
        this.level = "WARN";
    }

    protected void write(String message) {
        System.out.println("WARN: " + message);
    }
}
