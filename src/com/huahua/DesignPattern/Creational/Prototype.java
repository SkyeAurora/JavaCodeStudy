package src.com.huahua.DesignPattern.Creational;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/12
 */
class shape implements Cloneable {
    private String type;

    public shape(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    protected shape clone() {
        try {
            return (shape) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}

public class Prototype {
    public static void main(String[] args) {
        shape circle = new shape("circle");

        shape clonedCircle = circle.clone();
        clonedCircle.setType("Cloned Circle");

        System.out.println("Original Shape Type: " + circle.getType());
        System.out.println("Cloned Shape Type: " + clonedCircle.getType());
    }
}
