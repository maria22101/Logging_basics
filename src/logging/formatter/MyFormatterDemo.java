package logging.formatter;

import java.util.Arrays;
import java.util.logging.*;

public class MyFormatterDemo extends Formatter {

    @Override
    public String format(LogRecord record) {
        return record.getLevel() + ":" + record.getMessage() + "\n";
    }

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("");
        Logger logger1 = Logger.getLogger("1");
        Logger logger2 = Logger.getLogger("1.2");

        logger1.addHandler(new ConsoleHandler());
        logger2.addHandler(new ConsoleHandler());

        logger1.setLevel(Level.SEVERE);
        logger2.setLevel(Level.WARNING);

        MyFormatterDemo myFormatter = new MyFormatterDemo();

        Handler[] handlers = logger.getHandlers();
        Handler[] handlers1 = logger1.getHandlers();
        Handler[] handlers2 = logger2.getHandlers();

        Arrays.stream(handlers).forEach(h -> h.setFormatter(myFormatter));
        Arrays.stream(handlers1).forEach(h -> h.setFormatter(myFormatter));
        Arrays.stream(handlers2).forEach(h -> h.setFormatter(myFormatter));

        //the messages will be displayed as per the format in the overridden format() method of myFormatterDemo class
        logger.info("message from root logger");
        logger1.severe("message from first logger");
        logger2.warning("message from second logger");
    }
}
