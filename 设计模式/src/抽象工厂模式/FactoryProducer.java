package 抽象工厂模式;

public class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        if (choice.equals("Shape")) {
            return new ShapeFactory();
        } else if (choice.equals("Color")) {
            return new ColorFactory();
        }
        return null;
    }
}
