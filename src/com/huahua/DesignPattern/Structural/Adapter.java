package src.com.huahua.DesignPattern.Structural;

/**
 * @description: 适配器模式
 * 适配器合并两个不兼容的接口，将一个接口转化为另一种接口
 * @author：张佳伟
 * @date: 2024/8/13
 */
class LegacyRectangle {
    public void display(int x1, int x2, int y1, int y2) {
        System.out.println("LegacyRectangle: Point1(" + x1 + ", " + y1 + "), Point2(" + x2 + ", " + y2 + ")");
    }
}

interface Shape {
    public void draw(int x, int y, int width, int height);
}

class RectangleAdapter implements Shape {
    private LegacyRectangle legacyRectangle;

    public RectangleAdapter(LegacyRectangle legacyRectangle) {
        this.legacyRectangle = legacyRectangle;
    }

    @Override
    public void draw(int x, int y, int width, int height) {
        legacyRectangle.display(x, x + width, y, y + height);
    }
}

public class Adapter {
    public static void main(String[] args) {
        LegacyRectangle legacyRectangle = new LegacyRectangle();
        Shape shapeAdapter = new RectangleAdapter(legacyRectangle);

        shapeAdapter.draw(10, 20, 50, 30);
    }
}
