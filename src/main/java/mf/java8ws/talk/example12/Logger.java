package mf.java8ws.talk.example12;

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
}
