package chain;

/**
 * Created by Марат on 15.11.2016.
 */
public abstract class Logger {
    protected Level level;

    protected Logger nextLogger;

    public void setNext(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void log(String message) {
        if (isCorrect(message)) {
            String text = message.substring(message.indexOf('[', 2), message.length());
            write(text);

        }
        if (nextLogger != null) {
            nextLogger.log(message);
        }
    }

    protected abstract boolean isCorrect(String message);

    abstract protected void write(String message);
}
