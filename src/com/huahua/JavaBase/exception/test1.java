package src.com.huahua.JavaBase.exception;

import java.util.Scanner;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/9/8
 */
public class test1 {
    public static void validAge(int age) {
        if (age > 18) {
            throw new IllegalArgumentException("Age is older than 18");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int age = in.nextInt();

        try {
            validAge(age);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
