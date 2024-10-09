package src.com.huahua.DesignPattern.Structural;

/**
 * @description: 某些情况下，我们需要在不修改现有对象结构的情况下去动态的添加功能或者责任
 * @author：张佳伟
 * @date: 2024/8/15
 */
interface Coffee {
    double cost();

    String description();
}

class SimpleCoffee implements Coffee {

    @Override
    public double cost() {
        return 2.0;
    }

    @Override
    public String description() {
        return "Simple Coffee";
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost();
    }

    @Override
    public String description() {
        return decoratedCoffee.description();
    }
}

class MilkDecorator extends CoffeeDecorator {

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return super.cost() + 1.0;
    }

    @Override
    public String description() {
        return super.description() + "with Milk";
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return super.cost() + 0.5;
    }

    @Override
    public String description() {
        return super.description() + "with Sugar";
    }
}


public class Decorator {
    public static void main(String[] args) {
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println("Cost: $" + simpleCoffee.cost() + ", Description: " + simpleCoffee.description());

        Coffee MilkCoffee = new MilkDecorator(simpleCoffee);
        System.out.println("Cost: $" + MilkCoffee.cost() + ", Description: " + MilkCoffee.description());

        Coffee sugarMilkCoffee = new SugarDecorator(MilkCoffee);
        System.out.println("Cost: $" + sugarMilkCoffee.cost() + ", Description: " + sugarMilkCoffee.description());
    }
}