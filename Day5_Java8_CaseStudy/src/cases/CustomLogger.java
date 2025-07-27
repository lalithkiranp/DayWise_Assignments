package cases;

import java.util.function.Predicate;
import java.util.function.Consumer;

interface LogFilter {
    boolean filter(String message);
}

public class CustomLogger {
    public void log(String message, LogFilter filter) {
        if (filter.filter(message)) {
            System.out.println("LOG: " + message);
        }
    }

    public static void main(String[] args) {
        CustomLogger logger = new CustomLogger();

        logger.log("Error: Null Pointer", msg -> msg.contains("Error"));

        Predicate<String> containsInfo = msg -> msg.contains("Info");
        Consumer<String> logConsumer = msg -> System.out.println("LOG: " + msg);

        if (containsInfo.test("Info: Starting Service")) {
            logConsumer.accept("Info: Starting Service");
        }
    }
}