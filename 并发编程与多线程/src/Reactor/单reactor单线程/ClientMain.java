package Reactor.单reactor单线程;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClientMain {
    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                Socket socket;
                OutputStream out = null;
                try {
                    socket = new Socket("127.0.0.1", 8888);
                    out = socket.getOutputStream();
                    String s = "hello world";
                    System.out.println(Thread.currentThread().getName() + "已发送消息...");
                    out.write(s.getBytes());
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (out != null) {
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }
}
