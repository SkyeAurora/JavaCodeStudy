package src.com.huahua.Concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @description: Thread的创建方式
 * @author：张佳伟
 * @date: 2024/8/4
 */


public class ThreadTest {
    private static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Creating Thread By extends Thread Class");
        }
    }

    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Creating Thread By Implements Runnable Interface");
        }
    }

    private static class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "Creating Thread By Implements Callable Interface";
        }
    }
    public static void main(String[] args) {
        // 继承Thread类
//        MyThread myThread = new MyThread();
//        myThread.start();


        // 实现Runnable接口
        // Thread thread = new Thread(new MyRunnable());
//        thread.start();


        // 实现Callable接口
//        FutureTask<String> futureTask = new FutureTask<String>(new MyCallable());
//        Thread t = new Thread(futureTask);
//        t.start();
//        try {
//            String res = futureTask.get();
//            System.out.println("Callable Result: " + res);
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }

        // 使用线程池的框架 Executor
//        Executor executor = new Executor() {
//            @Override
//            public void execute(Runnable command) {
//                new Thread(command).start();
//            }
//        };
//        executor.execute(new MyRunnable());

        // 使用Executors来创建线程池提交任务实现
        /*
         * Executors 内置的几种线程池
         *
         */
        ExecutorService executor = Executors.newFixedThreadPool(10);

        List<Callable<Integer>> taskList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            final int index = i;
            taskList.add(() -> {
                Thread.sleep(1000);
                return index * index;
            });
        }

        try {
            List<Future<Integer>> futures = executor.invokeAll(taskList);

            for (Future<Integer> future : futures) {
                Integer res = future.get();
                System.out.println("Task Result : " + res);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

    }
}