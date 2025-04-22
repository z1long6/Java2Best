package com.java.spi;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class LoggerService implements Logger{
    public static final LoggerService SERVICE = new LoggerService();

    public final Logger logger;
    public final List<Logger> loggers_list;

    public LoggerService() {
        ServiceLoader<Logger>loader = ServiceLoader.load(Logger.class);

        List<Logger> loggers = new ArrayList<>();
        for (Logger logger : loader) {
            loggers.add(logger);
        }
        loggers_list = loggers;
        if (!loggers_list.isEmpty()) {
            logger = loggers_list.getFirst();
        }else {
            logger = null;
        }
    }

    public static LoggerService getLoggerService() {
        return SERVICE;
    }

    @Override
    public void info(String message) {
        if (logger != null) {
            logger.info(message);
        }else {
            System.out.println("Not found Logger Provider");
        }
    }

    @Override
    public void debug(String message) {
        if (logger != null) {
            loggers_list.forEach(logger -> logger.debug(message));
        }else {
            System.out.println("Not found Logger Provider");
        }
    }
}
