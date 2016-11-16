package chain;

/**
 * Created by Марат on 15.11.2016.
 */
public class InfoLogger extends Logger {
    public InfoLogger() {
        this.level = "INFO";
    }

    protected void write(String message) {
        System.out.println("INFO: " + message);
    }
}
