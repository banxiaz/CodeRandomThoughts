package Reactor.ForDebug;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TCPSelfConn {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket();
            socket.bind(new InetSocketAddress("localhost", 9999));
            socket.connect(new InetSocketAddress("localhost", 9999));

            //  TCP    127.0.0.1:9999         127.0.0.1:9999         ESTABLISHED     11944
            //  TCP自连接测试成功！
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
