package src.com.huahua.JavaBase.ClassTest;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/9/8
 */
class A {
    static String A = "A";
    String s;

    static {
        System.out.println("static" + A);
    }

    {
        System.out.println("block1" + s);
    }

    A() {
        System.out.println(A + "Constructor");
        s = "A";
    }
}

class B extends A {
    static String B = "B";

    static {
        System.out.println("static" + B);
    }

    {
        System.out.println("block1" + s);
    }

    B() {
        System.out.println(B + "Constructor");
        s = "B";
    }
}

public class OrderOfExecution {
    public static void main(String[] args) {
        new B();
    }
}
