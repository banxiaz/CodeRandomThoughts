package 观察者模式;

public abstract class Observer {
    // 需要将自己加入到被观察者中，被观察者有一个属性用来记录观察者观察的目标
    protected Subject subject;

    // 有事件发生时应该做什么
    public abstract void update();
}
