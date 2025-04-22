package com.java.spi;

public class Main {
    public static void main(String[] args) {
        LoggerService loggerService = LoggerService.getLoggerService();
        loggerService.info("1");
        loggerService.debug("2");
    }
}
