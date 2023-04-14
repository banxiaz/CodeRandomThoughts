package ThreadPoolExecutorDemo;

import java.util.concurrent.*;

public class FutureTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String> submit = executorService.submit(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "abc";
        });

        System.out.println("main");
        try {
            System.out.println(submit.isDone());
            System.out.println(submit.get(6, TimeUnit.SECONDS)); //阻塞直到返回结果，或者超时
            System.out.println(submit.isDone());
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
        System.out.println("main2");
    }
}
