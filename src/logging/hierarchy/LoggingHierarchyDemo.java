package logging.hierarchy;

import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

/**
 * Demonstration of basic work of loggers' hierarchy
 */
public class LoggingHierarchyDemo {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(""); //root logger
        Logger logger1 = Logger.getLogger("1");
        Logger logger2 = Logger.getLogger("1.2");

        //no necessity to assign a Handler for the root logger as it gets the ConsoleHandler by default
        logger1.addHandler(new ConsoleHandler());
        logger2.addHandler(new ConsoleHandler());

        logger.info("msg: from root"); // will be displayed once
        logger1.info("msg: from first"); // will be displayed twice (also on the root logger level)
        logger2.info("msg: from second"); // will be displayed three times (on the parent loggers' levels)
    }

}
