package ru.itis.kpfu.chainofresponsability;

/**
 * Created by Марат on 13.11.2016.
 */
public class TextLogger {
    String text;
    int level;

    void WriteMessage(String request) {
        String[] s = request.split(":");
        text = s[1].substring(1, s[1].indexOf("]"));
        Logger logger;
        switch (s[0]) {
            case "[1]":
                logger = new InfoLogger();
                break;
            case "[2]":
                logger = new WarnLogger();
                break;
            case "[3]":
                logger = new ErrorLogger();
                break;
            default:
                logger = new InfoLogger();
                break;
        }
        logger.writeText(text);
    }
}
