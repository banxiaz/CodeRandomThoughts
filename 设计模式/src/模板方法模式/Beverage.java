package 模板方法模式;

// Beverage 抽象类，制作饮料,包裹一个模板的全部实现步骤
public interface Beverage {
    void BoilWater(); //煮开水

    void Brew(); //冲泡

    void PourInCup(); //倒入杯中

    void AddThings(); //添加酌料

    boolean WantAddThings(); //是否加入酌料Hook
}
