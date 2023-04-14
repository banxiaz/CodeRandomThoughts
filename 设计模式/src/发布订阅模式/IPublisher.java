package 发布订阅模式;

//发布者接口
public interface IPublisher<T> {
    public void publish(SubscribePublish<T> subscribePublish, T message, boolean isInstantMsg);
}
