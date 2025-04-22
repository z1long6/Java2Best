package com.java.io;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NIO {
    static int count = 0;
    private static final String HOST = "localhost";
    private static final int PORT = 8080;
    private static boolean flag = true;

    public static void main(String[] args) throws Exception {

        try(ExecutorService executorService = Executors.newCachedThreadPool()){
            // nio
            try(ServerSocketChannel ssc = ServerSocketChannel.open()){
                ssc.socket().bind(new InetSocketAddress(HOST, PORT));
                Selector selector = Selector.open();
                ssc.register(selector, ssc.validOps());
                while(flag){
                    if(count > 10) flag = false;
                    int num = selector.select();
                    if (num == 0) continue;

                    Iterator<SelectionKey>events = selector.selectedKeys().iterator();
                    while (events.hasNext()) {
                        SelectionKey event = events.next();
                        if (event.isAcceptable()) {
                            SocketChannel sc = ssc.accept();
                            sc.configureBlocking(false);
                            sc.register(selector, SelectionKey.OP_READ);
                            count++;
                        } else if (event.isReadable()) {
                            try {
                                SocketChannel sc = (SocketChannel) event.channel();
                                ByteBuffer buf = ByteBuffer.allocate(1024);
                                int size = sc.read(buf);
                                if(-1==size){
                                    sc.close();
                                }
                                String result = new String(buf.array()).trim();
                                ByteBuffer wrap = ByteBuffer.wrap(("PONG:" + result).getBytes());
                                sc.write(wrap);
                            } catch (Exception ex) {
                                System.out.println("here");
                            }
                        } else if (event.isWritable()) {
                            SocketChannel sc = (SocketChannel) event.channel();
                        }
                        events.remove();
                    }
                }
            }
        }
    }
}
