package src.com.huahua.JavaBase.StringTest;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/9/8
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = "ssss";
        String s2 = "ss";
        System.out.println("s1:" + System.identityHashCode(s1));
        System.out.println("s2:" + System.identityHashCode(s2));
        System.out.println("After Changed s2:" + System.identityHashCode(s2));
    }
}
