package ru.itis.kpfu.chainofresponsability;

/**
 * Created by Марат on 13.11.2016.
 */

public abstract class Logger {
    Logger next;
    int level;

    public Logger(int level) {
        this.level = level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setNext(Logger next) {
        this.next = next;
    }

    public void writeText(String text) {
        if (1 <= this.level) {
            write(text);
        }
        if (next != null) {
            next.writeText(text);
        }
    }

    abstract void write(String text);
}


