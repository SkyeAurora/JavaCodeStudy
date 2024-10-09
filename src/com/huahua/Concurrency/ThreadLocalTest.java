package src.com.huahua.Concurrency;

/**
 * @description: ThreadLocal
 * @author：张佳伟
 * @date: 2024/8/16
 */
public class ThreadLocalTest {

    private static final ThreadLocal<Integer> threadLocalCounter = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        new Thread(new Task(),"Thread 1").start();
        new Thread(new Task(),"Thread 2").start();
        new Thread(new Task(),"Thread 3").start();
    }

    private static class Task implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                int counter = threadLocalCounter.get();
                threadLocalCounter.set(counter + 1);

                System.out.println(Thread.currentThread().getName() + "counter:" + threadLocalCounter.get());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
