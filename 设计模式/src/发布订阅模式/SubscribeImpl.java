package 发布订阅模式;

public class SubscribeImpl<T> implements ISubscriber<T> {
    public String name;

    public SubscribeImpl(String name) {
        this.name = name;
    }

    @Override
    public void subscribe(SubscribePublish<T> subscribePublish) {
        subscribePublish.subscribe(this);
    }

    @Override
    public void unSubscribe(SubscribePublish<T> subscribePublish) {
        subscribePublish.unSubscribe(this);
    }

    @Override
    //回调函数
    public void update(String publisher, T message) {
        System.out.println(this.name + "收到" + publisher + "发送过来的消息：" + message.toString());
    }
}
