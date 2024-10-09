package src.com.huahua.DesignPattern.Structural;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/15
 */
interface Shape1 {
    void draw(int x, int y);
}

class Oval implements Shape1 {

    private final Color color;

    public Oval(Color color) {
        this.color = color;
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("Drawing a " + color + " circle at (" + x + "," + y + ")");
    }
}

class ShapeFactory {
    private static final Map<Color, Shape1> ovalMap = new HashMap<>();

    public static Shape1 getOval(Color color) {
        Shape1 oval = ovalMap.get(color);
        if (oval == null) {
            oval = new Oval(color);
            ovalMap.put(color, oval);
        }
        return oval;
    }
}

public class Flyweight {
    public static void main(String[] args) {
        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};

        for (int i = 0; i < 20; i++) {
            Color randomColor = colors[(int) (Math.random() * colors.length)];
            Shape1 circle = ShapeFactory.getOval(randomColor);
            circle.draw((int) (Math.random() * 100), (int) (Math.random() * 100));
        }
    }
}
