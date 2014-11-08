package mf.java8ws.examples.example12;

import java.util.function.Supplier;

public class Logger {
    public enum Level {
        ERROR, WARN, INFO, DEBUG
    }

    private final Level level;

    public Logger(Level level) {
        this.level = level;
    }

    public void log(Level level, String message) {
        if (isLoggable(level)) {
            System.out.println(message);
        }
    }

    public boolean isLoggable(Level level) {
        return this.level.compareTo(level) >= 0;
    }

    public void log(Level level, Supplier<String> message) {
        if (isLoggable(level)) {
            System.out.println(message.get());
        }
    }
}
