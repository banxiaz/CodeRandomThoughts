package Reactor.BIO;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888, 10, InetAddress.getByName("127.0.0.1"));
            System.out.println("初始化ServerSocket，开始监听...");
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(() -> {
                    try {
                        System.out.println(Thread.currentThread().getName() + " " + socket.getRemoteSocketAddress());
                        byte[] byteRead = new byte[1024];
                        int len = socket.getInputStream().read(byteRead, 0, 1024);
                        String msg = new String(byteRead, 0, len);
                        System.out.println("收到消息，长度:" + len + " 消息为:" + msg);

                        byte[] byteWriter = "Hello".getBytes();
                        socket.getOutputStream().write(byteWriter);
                        System.out.println("Hello消息已经发送...");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
