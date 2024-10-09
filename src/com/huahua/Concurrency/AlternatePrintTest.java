package src.com.huahua.Concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 实现线程交替打印奇偶数
 * @author：张佳伟
 * @date: 2024/9/17
 */
public class AlternatePrintTest {
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static boolean flag = false;
    private static final int PRINT_COUNT = 100;

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 1; i < PRINT_COUNT; i += 2) {
                lock.lock();
                while (flag) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(i);
                condition.signal();
                flag = true;
                lock.unlock();
            }
        }).start();
        new Thread(() -> {
            for (int i = 2; i <= PRINT_COUNT; i += 2) {
                lock.lock();
                while (!flag) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(i);
                condition.signal();
                flag = false;
                lock.unlock();
            }
        }).start();
    }
}
