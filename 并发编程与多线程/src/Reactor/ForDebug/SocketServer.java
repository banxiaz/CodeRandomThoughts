package Reactor.ForDebug;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888, 10, InetAddress.getByName("localhost"));
            Socket accept = serverSocket.accept();

            System.out.println(accept.getRemoteSocketAddress());

            InputStream inputStream = accept.getInputStream();
            OutputStream outputStream = accept.getOutputStream();

            byte[] bytes = new byte[1024];
            while (true) {
                int len = inputStream.read(bytes);
                if (len == -1) {
                    outputStream.write("close()".getBytes()); // Software caused connection abort: socket write error
                    accept.close();
                    break;
                }
                System.out.println(len);
                System.out.println(new String(bytes, 0, len));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

