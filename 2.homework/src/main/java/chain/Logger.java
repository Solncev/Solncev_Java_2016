package chain;

/**
 * Created by Марат on 15.11.2016.
 */
public abstract class Logger {
    protected String level;

    protected Logger nextLogger;

    public void setNext(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public abstract void log(String message);

    protected static String getLevel(String message) {
        String[] s = message.split(" : ");
        String pr = s[0];
        pr = pr.substring(1, pr.length() - 1);
        return pr;
    }


    abstract protected void write(String message);
}
