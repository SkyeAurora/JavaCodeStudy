package src.com.huahua.LeetCode;

import java.util.Arrays;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/15
 */
public class LCR103 {

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{186, 419, 83, 408}, 6249));
    }

    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int count = 0, index = coins.length - 1;
        while (index >= 0 && coins[index] > amount) {
            index--;
        }
        for (; index >= 0; index--) {
            count += amount / coins[index];
            amount %= coins[index];
        }
        return amount == 0 ? count : -1;
    }
}
