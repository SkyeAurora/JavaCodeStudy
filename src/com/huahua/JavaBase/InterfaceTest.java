package src.com.huahua.JavaBase;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/11
 */
public interface InterfaceTest {
    void method1();

    default void method2() {
        System.out.println("method2()");
    }

    static void staticMethod(){
        System.out.println("staticMethod");
    }
}
