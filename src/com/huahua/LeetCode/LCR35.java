package src.com.huahua.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LCR35 {
    public static void main(String[] args) {
        List<String> timePoints = new ArrayList<>();
        timePoints.add("23:59");
        timePoints.add("00:00");
        System.out.println(findMinDifference(timePoints));
    }

    public static int findMinDifference(List<String> timePoints) {
        int len = timePoints.size();
        int[] minutes = new int[len];
        for (int i = 0; i < len; i++) {
            String time = timePoints.get(i);
            minutes[i] = TimeToMinutes(time);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int t = Math.abs(minutes[i] - minutes[j]);
                ans = Math.min(ans, Math.min(t, 1440 - t));
            }
        }
        return ans;
    }

    private static int TimeToMinutes(String time) {
        String[] times = time.split(":");
        return Integer.valueOf(times[0]) * 60 + Integer.valueOf(times[1]);
    }
}
