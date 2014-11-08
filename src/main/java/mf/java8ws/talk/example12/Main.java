package mf.java8ws.talk.example12;

public class Main {

    public static void main(String[] args) {
        Logger logger = new Logger(Logger.Level.WARN);
        logger.log(Logger.Level.ERROR, "this is a critical error");
        logger.log(Logger.Level.INFO, "this is just a info");
    }
}
