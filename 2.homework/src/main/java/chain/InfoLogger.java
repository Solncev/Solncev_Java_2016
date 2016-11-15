package chain;

/**
 * Created by Марат on 15.11.2016.
 */
public class InfoLogger extends Logger {
    public InfoLogger(int level) {
        this.level = level;
    }

    protected void write(String message) {
        System.out.println("INFO: " + message);
    }
}
