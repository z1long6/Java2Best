package com.java.lambda;

public class Main {
    public static void main(String[] args) {
        Message send = (String name) -> {
            System.out.println("hello " + name);
        };
        send.sendMessage("LiSan");
    }

}
