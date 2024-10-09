package src.com.huahua.JavaBase;

import java.util.*;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/7/30
 */
public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("executing now...");
            }
        };
        timer.schedule(task,1000,1000);
    }
}
