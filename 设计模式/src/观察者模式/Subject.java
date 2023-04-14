package 观察者模式;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    //被观察的对象持有一个队列，所有观察它的观察者都要主动把自己加入/注册这个队列，然后由被观察对象主动通知所有观察者
    private final List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
