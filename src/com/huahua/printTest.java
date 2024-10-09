package src.com.huahua;

import java.util.concurrent.atomic.AtomicBoolean;

public class printTest {
    private static final int PRINT_COUNT = 100;

    public static void main(String[] args) {
        AtomicBoolean flag = new AtomicBoolean(false);

        new Thread(() -> {
            for (int i = 0; i <= PRINT_COUNT; ) {
                if (!flag.get()) {
                    System.out.println("Thread1 print: " + i);
                    i += 2;
                    flag.set(true);
                }
                System.out.println("Thread1 yield");
                Thread.yield();
            }
        }).start();

        new Thread(() -> {
            for (int i = 1; i <= PRINT_COUNT; ) {
                if (flag.get()) {
                    System.out.println("Thread2 print: " + i);
                    i += 2;
                    flag.set(false);
                }
                System.out.println("Thread2 yield");
                Thread.yield();
            }
        }).start();
    }
}
