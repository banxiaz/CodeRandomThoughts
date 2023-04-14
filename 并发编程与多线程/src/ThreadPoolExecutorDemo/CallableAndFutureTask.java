package ThreadPoolExecutorDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableAndFutureTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Callable可以直接通过线程池的submit来执行，并且通过返回一个Future，以获取线程执行的结果
        // 还可以通过FutureTask来获得返回结果
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(5000);
                return "hello";
            }
        });

        new Thread(futureTask).start();
        System.out.println(futureTask.get());

        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        FutureTask<String> futureTask1 = new FutureTask<>(runnable, "result");
        new Thread(futureTask1).start();
        System.out.println(futureTask1.get());
    }
}
