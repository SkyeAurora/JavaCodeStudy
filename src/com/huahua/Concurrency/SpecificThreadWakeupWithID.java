package src.com.huahua.Concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/24
 */
public class SpecificThreadWakeupWithID {
    private final Lock lock = new ReentrantLock();
    private final Map<Long, Condition> conditionMap = new HashMap<>();

    public static void main(String[] args) {

    }

    public void awaitWithID(long threadID) throws InterruptedException {
        lock.lock();
        try {
            Condition condition = lock.newCondition();
            conditionMap.put(threadID, condition);
            condition.await();  // Thread waits here
        } finally {
            lock.unlock();
        }
    }

    public void signalThread(long threadID) {
        lock.lock();
        try {
            Condition condition = conditionMap.get(threadID);
            if (condition != null) {
                condition.signal();  // Wake up the specific thread
                conditionMap.remove(threadID);  // Clean up the map entry
            }
        } finally {
            lock.unlock();
        }
    }
}
