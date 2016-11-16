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

    public void log(String request) {
        if (this.level.equals(getLevel(request))) {
            String[] s = request.split(" : ");
            String message = s[1];
            if (nextLogger != null) {
                nextLogger.log(request);
            }
            write(message);
        } else {
            if (nextLogger != null) {
                nextLogger.log(request);
            }
        }
    }

    private String getLevel(String request) {
        String[] s = request.split(" : ");
        String pr = s[0];
        pr = pr.substring(1, pr.length() - 1);
        return pr;
    }


    abstract protected void write(String message);
}
