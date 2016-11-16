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

    public void log(String message) {
        if (this.level.equals(getLevel(message))) {
            String[] s = message.split(" : ");
            String text = s[1];
            if (nextLogger != null) {
                nextLogger.log(message);
            }
            write(text);
        } else {
            if (nextLogger != null) {
                nextLogger.log(message);
            }
        }
    }

    private String getLevel(String message) {
        String[] s = message.split(" : ");
        String pr = s[0];
        pr = pr.substring(1, pr.length() - 1);
        return pr;
    }


    abstract protected void write(String message);
}
