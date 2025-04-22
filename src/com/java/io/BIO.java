package com.java.io;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIO {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        int connectedNum = 0;
        int port = 8888;
        ExecutorService es = Executors.newCachedThreadPool();
        ServerSocket ss = new ServerSocket(port);
        while(!flag){
            if (connectedNum == 10){
                flag = true;
            }
            Socket s = ss.accept();
            es.execute(() -> {
                try{
                    Scanner sc = new Scanner(s.getInputStream());
                    PrintStream pw = new PrintStream(s.getOutputStream());
                    while(!flag){
                        String line = sc.next().trim();
                        pw.println("[reply]: " + line);
                    }

                }catch (Exception e){
                    System.out.println("ss");
                }
            });
            connectedNum++;
        }
        es.shutdown();
        ss.close();
    }
}
