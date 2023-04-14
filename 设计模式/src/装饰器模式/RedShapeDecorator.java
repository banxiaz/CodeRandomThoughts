package 装饰器模式;

public class RedShapeDecorator extends ShapeDecorator {
    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        // decoratedShape.draw();
        super.draw();
        System.out.println("Border Color: Red");
    }
}
