package src.com.huahua.JavaBase.lambda;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/16
 */
interface MyFunctionalInterface {
//    void doSomething();

    void add(int a, int b);
}

public class lambdaTest {
    public static void main(String[] args) {
//        MyFunctionalInterface myFunctionalInterface = new MyFunctionalInterface() {
//            @Override
//            public void doSomething() {
//                System.out.println("do Something");
//            }
//        };
        // MyFunctionalInterface myFunctionalInterface = () -> System.out.println("do Something");
        MyFunctionalInterface myFunctionalInterface = (a, b) -> System.out.println(a + b);
        myFunctionalInterface.add(3,4);
    }
}
