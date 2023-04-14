package Reactor.单reactor单线程;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class WorkHandler implements Runnable {
    private final SocketChannel socketChannel;

    public WorkHandler(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        try {
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.clear();
            int len = socketChannel.read(byteBuffer); //如果len=-1表示另外一端调用了close()
            String msg = new String(byteBuffer.array(), 0, len, StandardCharsets.UTF_8);
            System.out.println(socketChannel.getRemoteAddress() + "发送来的消息是：" + msg);

            socketChannel.write(ByteBuffer.wrap("来自服务端的响应...".getBytes(StandardCharsets.UTF_8)));
            socketChannel.close(); //很重要的操作
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
