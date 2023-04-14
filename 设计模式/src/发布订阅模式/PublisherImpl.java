package 发布订阅模式;

public class PublisherImpl<T> implements IPublisher<T> {
    private String name;

    public PublisherImpl(String name) {
        this.name = name;
    }

    @Override
    public void publish(SubscribePublish<T> subscribePublish, T message, boolean isInstantMsg) {
        subscribePublish.publish(this.name, message, isInstantMsg);
    }
}
