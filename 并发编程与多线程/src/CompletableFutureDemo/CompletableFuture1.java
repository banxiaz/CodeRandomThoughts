package CompletableFutureDemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFuture1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        System.out.println(completableFuture.isDone());
        completableFuture.complete("finish"); // 设置值
        System.out.println(completableFuture.get());
        System.out.println(completableFuture.isDone());

        CompletableFuture<String> completableFuture1 = CompletableFuture.completedFuture("hello");
        System.out.println(completableFuture1.get());

        CompletableFuture<String> completableFuture2 = new CompletableFuture<>();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            completableFuture2.complete("hihi");
        }).start();

        System.out.println(completableFuture2.get());
    }
}
