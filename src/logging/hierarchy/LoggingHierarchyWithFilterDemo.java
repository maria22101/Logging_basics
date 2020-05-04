package logging.hierarchy;

import java.util.logging.ConsoleHandler;
import java.util.logging.Filter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class LoggingHierarchyWithFilterDemo {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("");
        Logger logger1 = Logger.getLogger("1");
        Logger logger2 = Logger.getLogger("1.2");

        logger1.addHandler(new ConsoleHandler());
        logger2.addHandler(new ConsoleHandler());

        logger1.setFilter(new Filter() {
            @Override
            public boolean isLoggable(LogRecord record) {
                return false;
            }
        });

        logger.info("msg:"); // will be displayed once

        logger1.info("msg: first"); // won't be displayed as the Filter set reject all messages. The message
        //will either not propagated up through the hierarchy

        logger2.info("msg: second"); // will be displayed three times (on the parent loggers' levels). The
        //filter set on the parent logger does not restrict its propagation up through the hierarchy
    }
}
