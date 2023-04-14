package 发布订阅模式;

public interface ISubscriber<T>{
    public void subscribe(SubscribePublish<T> subscribePublish);
    public void unSubscribe(SubscribePublish<T> subscribePublish);
    public void update(String publisher,T message);
}
