package src.com.huahua.DesignPattern;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/7/28
 */
public class ProducerConsumerModel {
    public static void main(String[] args) {
        BlockingDeque<Integer> queue = new LinkedBlockingDeque<>();

        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }
}

class Producer implements Runnable {
    private BlockingDeque<Integer> queue;

    Producer(BlockingDeque<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            try {
                System.out.println("Producer: producing==>" + i);
                queue.put(i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Consumer implements Runnable {
    private BlockingDeque<Integer> queue;

    Consumer(BlockingDeque<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer item = queue.take();
                System.out.println("Consumer: consuming==>" + item);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
