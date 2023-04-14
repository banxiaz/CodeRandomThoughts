package 观察者模式;

public class ObserverPatternDemo {
    public static void main(String[] args) {
        //被观察的对象
        Subject subject = new Subject();

        //有哪些观察者需要观察它，就把它加入
        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}
