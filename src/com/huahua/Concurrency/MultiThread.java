package src.com.huahua.Concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description: 如何确保并发安全？
 * 1. 对方法或者代码块加 synchronized 锁
 * 2. volatile 关键字仅能保证内存可见性，不能保证对变量操作的原子性，也就不能保证线程安全
 * 3. Lock接口与 ReentrantLock 类来对代码块进行加锁
 * 4. 使用AtomicInteger原子类保证操作原子性
 * 5. 使用ReadWhiteLock
 * @author：张佳伟
 * @date: 2024/8/16
 */
public class MultiThread {
    //    private final ReentrantLock lock = new ReentrantLock();
    private int cnt;
    // private final AtomicInteger cnt = new AtomicInteger(0);
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock whiteLock = lock.writeLock();

    public void increase() {
        whiteLock.lock();
        try {
            cnt++;
        } finally {
            whiteLock.unlock();
        }
    }

    public int get() {
        readLock.lock();
        try {
            return cnt;
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final int threadSize = 1000;
        MultiThread multiThread = new MultiThread();
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < threadSize; i++) {
            pool.execute(() -> {
                multiThread.increase();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        pool.shutdown();
        System.out.println(multiThread.get());
    }
}
