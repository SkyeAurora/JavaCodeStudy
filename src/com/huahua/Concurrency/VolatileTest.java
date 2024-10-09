package src.com.huahua.Concurrency;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/16
 */
public class VolatileTest {

    private static boolean flag = true;
    private static int cnt = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (flag) {
                System.out.println("cnt:" + (cnt++));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            flag = false;
            System.out.println("set flag false!");
        });

        t1.start();
        t2.start();
    }
}
