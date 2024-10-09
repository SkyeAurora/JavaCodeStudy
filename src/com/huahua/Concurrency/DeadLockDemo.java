package src.com.huahua.Concurrency;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/21
 */
public class DeadLockDemo {

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public static void main(String[] args) {
        DeadLockDemo demo = new DeadLockDemo();
        Thread t1 = new Thread(demo::method1, "Thread-1");
        Thread t2 = new Thread(demo::method2, "Thread-2");
        t1.start();
        t2.start();
    }

    /**
     * 持有 lock1 尝试获取 lock2
     */
    private void method1() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + "acquired lock1");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "waiting for lock2...");
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + "acquired lock2");
            }
        }
    }

    /**
     * 持有 lock1 尝试获取 lock2
     */
    private void method2() {
        synchronized (lock2) {
            System.out.println(Thread.currentThread().getName() + "acquired lock2");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "waiting for lock1...");
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + "acquired lock1");
            }
        }
    }

}
