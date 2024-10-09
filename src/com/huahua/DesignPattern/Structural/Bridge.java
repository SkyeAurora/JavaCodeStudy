package src.com.huahua.DesignPattern.Structural;

/**
 * @description: 桥接模式
 * ”组合优于继承“ 当一个类有多个变化维度，如果单纯使用继承来处理会导致类层次结构急剧变化，不利于维护。
 * 继承使抽象具体高强度耦合，不利于扩展。桥接模式将抽象部分与具体部分分离，使得他们可以独立变化。
 * @author：张佳伟
 * @date: 2024/8/13
 */
interface Color {
    void applyColor();
}

class Red implements Color {
    @Override
    public void applyColor() {
        System.out.println("Applying Red Color");
    }
}

class Blue implements Color {
    @Override
    public void applyColor() {
        System.out.println("Applying Blue Color");
    }
}

abstract class shape {
    protected Color color;

    public shape(Color color) {
        this.color = color;
    }

    abstract void draw();
}

class Circle extends shape {

    public Circle(Color color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.println("Drawing a Circle");
        color.applyColor();
    }
}

class Square extends shape {

    public Square(Color color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.println("Drawing a Square");
        color.applyColor();
    }
}

public class Bridge {
    public static void main(String[] args) {
        Color red = new Red();
        Color blue = new Blue();
        shape redCircle = new Circle(red);
        shape blueSquare = new Square(blue);
        redCircle.draw();
        blueSquare.draw();
    }
}
