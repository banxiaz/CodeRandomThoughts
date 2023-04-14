package 模板方法模式;

public class Main {
    public static void main(String[] args) {
        MakeCoffee makeCoffee = new MakeCoffee();
        makeCoffee.template.MakeBeverage();
    }
}
