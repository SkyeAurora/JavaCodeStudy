package src.com.huahua.JavaBase.generics;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/11
 */
public class operation {

    private static <T extends Number> double add(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }

    public static void main(String[] args) {
        System.out.println(add(100, 100));
    }
}
