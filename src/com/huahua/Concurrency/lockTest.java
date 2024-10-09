package src.com.huahua.Concurrency;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/17
 */
public class lockTest {

    private static final Object lock = new Object();
    private static int count = 1;
    private static final int MAX_COUNT = 1000;

    public static void main(String[] args) {
        Runnable printOdd = () -> {
            synchronized (lock) {
                while (count < MAX_COUNT) {
                    if (count % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + ": " + (count++));
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        Runnable printEven = () -> {
            synchronized (lock) {
                while (count < MAX_COUNT) {
                    if (count % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ": " + (count++));
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        Thread t1 = new Thread(printOdd,"printOdd");
        Thread t2 = new Thread(printEven,"printEven");

        t1.start();
        t2.start();
    }
}
