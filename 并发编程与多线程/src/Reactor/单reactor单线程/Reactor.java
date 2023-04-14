package Reactor.单reactor单线程;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

// https://blog.csdn.net/b1303110335/article/details/108880704

public class Reactor implements Runnable {
    ServerSocketChannel serverSocketChannel;
    Selector selector;
    InetSocketAddress address;

    public Reactor(int port) {
        try {
            serverSocketChannel = ServerSocketChannel.open(); //创建通道
            address = new InetSocketAddress("localhost", port);
            serverSocketChannel.socket().bind(address); //绑定监听地址
            serverSocketChannel.configureBlocking(false); //通道必须配置为非阻塞模式
            selector = Selector.open(); //创建选择器
            SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);//将通道注册到选择器上，指定要注册的具体事件：accept
            selectionKey.attach(new Acceptor(selector, serverSocketChannel));
            System.out.println("准备就绪，开始监听...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                int num = selector.select();
                System.out.println("selector监听到事件，数量为: " + num);

                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    dispatcher(key);
                    iterator.remove();

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void dispatcher(SelectionKey key) {
        String info = String.format("conn[%s] acc[%s] read[%s] write[%s] valid[%s]",
                key.isConnectable(), key.isAcceptable(), key.isReadable(), key.isWritable(), key.isValid());
        System.out.println(info);

        Runnable runnable = (Runnable) key.attachment();
        runnable.run(); //这里直接调用run()方法，没有使用多线程
    }
}

/*
    if (key.isAcceptable()) {

        ServerSocketChannel ssChannel1 = (ServerSocketChannel) key.channel();

        // 服务器会为每个新连接创建一个 SocketChannel
        SocketChannel sChannel = ssChannel1.accept();
        sChannel.configureBlocking(false);

        // 这个新连接主要用于从客户端读取数据
        sChannel.register(selector, SelectionKey.OP_READ);

    } else if (key.isReadable()) {

        SocketChannel sChannel = (SocketChannel) key.channel();
        log.info(readDataFromSocketChannel(sChannel));
        sChannel.close();
    }
 */
