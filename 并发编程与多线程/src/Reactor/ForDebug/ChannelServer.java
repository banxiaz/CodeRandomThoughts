package Reactor.ForDebug;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

// 通过ByteBuffer进行数据的读取和写入
// 通过Channel进行数据的传输
// SocketChannel 和 ServerSocketChannel在被实例化时都会创建一个对等 socket 对象，使用socket()和getChannel()方法
// 由于 ServerSocketChannel 没有 bind()方法，因此有必要取出对等的 socket 并使用它 来绑定到一个端口以开始监听连接
// 在 ServerSocket 上调用 accept( )方法会阻塞并等待返回一个Socket对象
// 在ServerSocketChannel 上调用accept()方法，可以使用非阻塞方式
// 如果 ServerSocketChannel 以非阻塞模式被调用，当没有传入连接在等待时， ServerSocketChannel.accept( )会立即返回 null
// ServerSocketChannel主要用途用来处理建立连接的通道；SocketChannel 主要用途用来处理网络 I/O 的通道
// 写入数据到Buffer -> 调用flip()方法，转换为读取模式 -> 从Buffer中读取数据 -> 调用buffer.clear()方法或者buffer.compact()方法清除缓冲区

public class ChannelServer {
    static Selector selector;

    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            ServerSocket serverSocket = serverSocketChannel.socket();
            serverSocket.bind(new InetSocketAddress("localhost", 8888)); //listen了
            serverSocketChannel.configureBlocking(false);

            selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            //开始由selector轮询
            while (true) {
                int num = selector.select();
                System.out.println("当前轮询到的socket数量为: " + num);

                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    dispatcher(key);
                    iterator.remove();
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void dispatcher(SelectionKey key) {
        printKeyInfo(key);

        if (key.isAcceptable()) {
            try {
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                SocketChannel sc = ssc.accept();
                sc.configureBlocking(false);
                sc.register(selector, SelectionKey.OP_READ);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (key.isReadable()) {
            try {
                SocketChannel sc = (SocketChannel) key.channel();
                readDataFromSocketChannel(sc);
                // sc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void readDataFromSocketChannel(SocketChannel sc) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);//1KB 默认写模式
        int len;

        while (true) {
            len = sc.read(buffer); //非阻塞的读！表示从sc读取数据到buffer中
            if (len == -1) {
                //写入数据
                sc.write(ByteBuffer.wrap("len=-1".getBytes(StandardCharsets.UTF_8))); //表示将buffer中的数据通过sc发送出去
                sc.close();
                break;
            } else if (len == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("HTTP/1.1 200 OK\n")
                        .append("Context-Type: text/html\n")
                        .append("\r\n")
                        .append(sc.getLocalAddress())
                        .append("\n")
                        .append(sc.getRemoteAddress());
                String msg = new String(sb);
                sc.write(ByteBuffer.wrap(msg.getBytes(StandardCharsets.UTF_8)));
                break;
            }
            buffer.flip(); //切换到读模式 limit=position、position=0、mark=-1
            System.out.println("读到数据长度：" + len);
            System.out.println(new String(buffer.array(), 0, len));
            buffer.clear(); //切换到写模式，不保留未读完的数据，compact()保留未读完的数据

        }
    }

    private static void printKeyInfo(SelectionKey key) {
        String info = String.format("connect[%s] accept[%s] read[%s] write[%s] valid[%s]",
                key.isConnectable(), key.isAcceptable(), key.isReadable(), key.isWritable(), key.isValid());
        System.out.println(info);
    }

}
