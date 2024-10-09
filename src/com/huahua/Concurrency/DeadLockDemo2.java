package src.com.huahua.Concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/21
 */
public class DeadLockDemo2 {

    private final Lock lock1 = new ReentrantLock();

    private final Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        DeadLockDemo2 demo = new DeadLockDemo2();
        Thread t1 = new Thread(demo::method1, "Thread-1");
        Thread t2 = new Thread(demo::method2, "Thread-2");

        t1.start();
        t2.start();
    }

    private void method1() {
        boolean flag = true;
        while (flag) {
            if (lock1.tryLock()) {
                System.out.println(Thread.currentThread().getName() + " acquired lock1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(Thread.currentThread().getName() + " waiting for lock2...");
                if (lock2.tryLock()) {
                    System.out.println(Thread.currentThread().getName() + " acquired lock2");
                    flag = false;
                    lock2.unlock();
                    System.out.println(Thread.currentThread().getName() + " unlock lock2");
                }
                lock1.unlock();
                System.out.println(Thread.currentThread().getName() + " unlock lock1");
            }
        }
    }

    private void method2() {
        boolean flag = true;

        while (flag) {
            if (lock2.tryLock()) {
                System.out.println(Thread.currentThread().getName() + " acquired lock2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(Thread.currentThread().getName() + " waiting for lock1...");
                if (lock1.tryLock()) {
                    System.out.println(Thread.currentThread().getName() + " acquired lock1");
                    flag = false;
                    lock1.unlock();
                    System.out.println(Thread.currentThread().getName() + " unlock lock1");
                }
                lock2.unlock();
                System.out.println(Thread.currentThread().getName() + " unlock lock2");
            }
        }
    }
}
