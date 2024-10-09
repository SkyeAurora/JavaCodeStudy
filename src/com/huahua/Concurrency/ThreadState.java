package src.com.huahua.Concurrency;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/15
 */
public class ThreadState {
    private static class MyRunnable implements Runnable {
        static final Object lock = new Object();

        @Override
        public void run() {
            synchronized (lock) {
                try {
                    // 进入 WAITING 状态
                    lock.wait();

                    // 模拟长时间运行，进入 TIMED_WAITING 状态
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        // 创建一个线程
        Thread thread = new Thread(new MyRunnable());

        // 1. NEW 状态
        System.out.println("State after thread creation: " + thread.getState());

        // 启动线程
        thread.start();

        // 2. RUNNABLE 状态
        System.out.println("State after calling start: " + thread.getState());

        // 主线程睡眠一段时间，确保子线程进入 WAITING 状态
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 3. WAITING 状态
        synchronized (MyRunnable.lock) {
            System.out.println("State after entering WAITING: " + thread.getState());
            MyRunnable.lock.notify(); // 释放子线程的等待
            System.out.println("State after entering WAITING: " + thread.getState());
        }

        // 主线程再睡眠一段时间，确保子线程进入 TIMED_WAITING 状态
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 4. TIMED_WAITING 状态
        System.out.println("State during sleep (TIMED_WAITING): " + thread.getState());

        try {
            thread.join(); // 等待子线程终止
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 5. TERMINATED 状态
        System.out.println("State after thread terminates: " + thread.getState());
    }
}


