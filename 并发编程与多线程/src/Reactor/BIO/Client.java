package Reactor.BIO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        new Thread(Client::connectServer).start();
        new Thread(Client::connectServer).start();
        new Thread(Client::connectServer).start();
    }

    public static void connectServer() {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("localhost", 8888));

            //发送消息
            String req = "Client Hello...";
            OutputStream clientRequest = socket.getOutputStream();
            clientRequest.write(req.getBytes());
            clientRequest.flush();

            //接收消息
            int maxLen = 1024;
            int realLen;
            byte[] bytes = new byte[maxLen];
            StringBuilder msg = new StringBuilder();
            InputStream clientResponse = socket.getInputStream();
            while ((realLen = clientResponse.read(bytes, 0, maxLen)) != -1) {// 需要另外一端主动发送socket.close()
                System.out.println("->" + realLen);
                msg.append(new String(bytes, 0, realLen));
            }
            System.out.println("收到消息 " + msg);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
