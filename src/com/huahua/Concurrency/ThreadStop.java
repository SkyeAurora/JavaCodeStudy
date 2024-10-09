package src.com.huahua.Concurrency;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/15
 */


public class ThreadStop {

    private static class MyThreadStopTest implements Runnable {
        private volatile boolean isThreadStillRunning = true;

        @Override
        public void run() {
            while (isThreadStillRunning) {
                System.out.println("Thread is running...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Thread was interrupted, stopping work...");
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Thread is stopped!");
        }

        public void stop() {
            isThreadStillRunning = false;
        }
    }


    public static void main(String[] args) {
        MyThreadStopTest myRunnable = new MyThreadStopTest();
        Thread t = new Thread(myRunnable);
        t.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myRunnable.stop();
    }
}
