package 发布订阅模式;

public class SubPubTest {
    public static void main(String[] args) {
        SubscribePublish<String> subscribePublish = new SubscribePublish<>("这是一个主题");
        IPublisher<String> publisher = new PublisherImpl<>("发布者");
        ISubscriber<String> subscriber1 = new SubscribeImpl<>("订阅者1");
        ISubscriber<String> subscriber2 = new SubscribeImpl<>("订阅者2");
        ISubscriber<String> subscriber3 = new SubscribeImpl<>("订阅者3");

        subscriber1.subscribe(subscribePublish);
        subscriber2.subscribe(subscribePublish);
        publisher.publish(subscribePublish, "welcome", true);
        publisher.publish(subscribePublish, "to", true);
        publisher.publish(subscribePublish, "java world", false);
        publisher.publish(subscribePublish, "java world2", false);
        System.out.println("= = = = = = = = = = = = = = = ");
        subscriber3.subscribe(subscribePublish);
        publisher.publish(subscribePublish, "java world3", false);
        publisher.publish(subscribePublish, "java world4", false);
        publisher.publish(subscribePublish, "java world5", false);
        publisher.publish(subscribePublish, "java world6", false);
    }
}
