package chain;

/**
 * Created by Марат on 15.11.2016.
 */
public class ErrorLogger extends Logger {
    public ErrorLogger() {
        this.level = "ERROR";
    }

    protected void write(String message) {
        System.out.println("ERROR: " + message);
    }
}
