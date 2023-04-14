package 模板方法模式;

public class MakeCoffee implements Beverage {
    Template template;

    public MakeCoffee() {
        template = new Template();
        template.beverage = this;
    }

    @Override
    public void BoilWater() {
        System.out.println("将水煮到100摄氏度");
    }

    @Override
    public void Brew() {
        System.out.println("用水冲咖啡豆");
    }

    @Override
    public void PourInCup() {
        System.out.println("将充好的咖啡倒入陶瓷杯中");
    }

    @Override
    public void AddThings() {
        System.out.println("添加牛奶和糖");
    }

    @Override
    public boolean WantAddThings() {
        return true;
    }
}
