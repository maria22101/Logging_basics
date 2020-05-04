package logging.hierarchy;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingHierarchyWithFilterAndLevelsDemo2 {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("");
        Logger logger1 = Logger.getLogger("1");
        Logger logger2 = Logger.getLogger("1.2");

        logger1.addHandler(new ConsoleHandler());
        logger2.addHandler(new ConsoleHandler());

        logger1.setLevel(Level.SEVERE);
        logger2.setLevel(Level.INFO);

        logger.info("msg: from root"); // will be displayed once

        logger1.info("msg: from first"); // will not be displayed and will not be propagated up through the hierarchy
        // because the actual message passed to the logger is of INFO level is lower than WARNING

        logger2.info("msg: from second"); // will be displayed three times
    }
}
