package chain;

import java.util.Scanner;

/**
 * Created by Марат on 15.11.2016.
 */
public class ChainTest {
    private static Logger getLogger(int level) {
        Logger infoLogger = new InfoLogger(Logger.INFO);
        Logger warnLogger = new WarnLogger(Logger.WARN);
        Logger errorLogger = new ErrorLogger(Logger.ERROR);

        errorLogger.setNextLogger(infoLogger);
        if (level == 3) {
            return errorLogger;
        } else {
            if (level == 2)
                return warnLogger;
        }
        return infoLogger;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] strings = s.split(":");
        int level = Integer.parseInt(String.valueOf(strings[0].charAt(1)));
        Logger logger = getLogger(level);
        logger.logMessage(level, strings[1]);
    }
}
