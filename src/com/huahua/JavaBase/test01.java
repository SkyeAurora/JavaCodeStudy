package src.com.huahua.JavaBase;

import src.com.huahua.JavaBase.clone.Person;

import java.util.Arrays;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/7/26
 */
public class test01 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1};
        System.out.println(Arrays.toString(nums));
        change(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void change(int[] nums) {
        nums = new int[]{2, 2};
    }
}
