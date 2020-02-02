package com.xhh.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 没有返回值");
        });
        completableFuture.get();
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 有返回值");
            //int number = 10 / 0;
            return 1024;
        });
        System.out.println(integerCompletableFuture.whenComplete((integer, throwable) -> {
            System.out.println(integer);
            System.out.println(throwable);
        }).exceptionally(throwable -> {
            System.out.println(throwable.getMessage());
            return 444;
        }).get());

    }
}
