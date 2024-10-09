package src.com.huahua.meituan;

import java.util.Scanner;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/9
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        in.nextLine();
        String str = in.nextLine();

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'M' || str.charAt(i) == 'T') {
                count++;
            }
        }
        System.out.println(n - count > k ? count + k : n);
    }
}
