package com.test.examples;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadSample {
    public static void main(String[] args) throws Exception {
        ThreadSample.runnable();

        ThreadSample.callable();

        ThreadSample.executorService();

        ThreadSample.executorList();
    }

    private static void runnable() {
        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName());
        };

        task.run();

        Thread thread = new Thread(task);
        thread.start();
        System.out.println("Done!");
    }
    private static void callable() throws Exception {
        Callable<Integer> task = () -> {
            System.out.println(Thread.currentThread().getName());
            return 1;
        };

        System.out.println(task.call());
    }

    private static void executorService() throws ExecutionException, InterruptedException {
        Callable<Integer> task = () -> {
            System.out.println(Thread.currentThread().getName());
            return 1;
        };

        ExecutorService executors = Executors.newFixedThreadPool(1);
        Future<Integer> future = executors.submit(task);

        Integer rs = future.get();
        System.out.println(rs);
        executors.shutdownNow();
    }

    private static void executorList() throws ExecutionException, InterruptedException {
        List<Callable<String>> tasks = Arrays.asList(
                () -> "task1",
                () -> "task2",
                () -> "task3"
        );

        ExecutorService executors = Executors.newFixedThreadPool(1);
        executors.invokeAll(tasks)
        .stream()
        .map(f -> {
            try {
                return f.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            return null;
        })
        .forEach(System.out::println);

        executors.shutdownNow();

    }
}
