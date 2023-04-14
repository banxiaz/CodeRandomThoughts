package 发布订阅模式;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Msg<T> {
    private String publisher;
    private T message;

    public Msg(String publisher, T message) {
        this.publisher = publisher;
        this.message = message;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
}

public class SubscribePublish<T> {
    //订阅器/主题 名称
    private String name;
    //订阅器队列容量
    final int QUEUE_CAPACITY = 2;
    //发布者发布的消息存储队列
    private BlockingQueue<Msg> queue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);
    //订阅者集合
    private List<ISubscriber<T>> subscribers = new ArrayList<>();

    public SubscribePublish(String name) {
        this.name = name;
    }

    public void publish(String publisher, T message, boolean isInstantMsg) {
        if (isInstantMsg) {
            update(publisher, message);
            return;
        }
        Msg<T> msg = new Msg<>(publisher, message);
        // 如果队列满了，则触发通知操作
        if (!queue.offer(msg)) {
            updateAndPut(msg);
        }
    }

    private void updateAndPut(Msg msg) {
        Msg<T> msgItem;
        //将队列里面的消息全部发送过去
        while ((msgItem = queue.poll()) != null) {
            this.update(msg.getPublisher(), msgItem.getMessage());
        }
        queue.offer(msg);
    }

    private void update(String publisher, T message) {
        for (ISubscriber<T> subscriber : subscribers) {
            //调用订阅者的回调函数
            subscriber.update(publisher, message);
        }
    }

    public void subscribe(ISubscriber<T> subscriber) {
        subscribers.add(subscriber);
    }

    public void unSubscribe(ISubscriber<T> subscriber) {
        subscribers.remove(subscriber);
    }

}
