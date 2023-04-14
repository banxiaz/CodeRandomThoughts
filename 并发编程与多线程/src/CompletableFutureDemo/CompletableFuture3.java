package CompletableFutureDemo;

import java.util.concurrent.*;
import java.util.function.*;

public class CompletableFuture3 {
    // 同步调用会沿用上一个任务的线程池，异步调用会使用默认的线程
    // 没有指定Executor的方法会使用ForkJoinPool.commonPool() 作为它的线程池执行异步代码。如果指定线程池，则使用指定的线程池运行
    // 需要从回调函数获取返回值使用 thenApply()
    // 不需要从回调函数获取返回值，但是需要前一步的结果，使用 thenAccept()
    // 既不需要从回调函数获取返回值，也不需要使用前一步的结果，使用 thenRun()
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                5,
                1,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5),
                new ThreadPoolExecutor.AbortPolicy()
        );

        // thenApply() 方法接受一个 Function 实例，用它来处理结果
        CompletableFuture<String> future1 = CompletableFuture.completedFuture("hello").thenApply(new Function<String, String>() {
            @Override
            public String apply(String s) {
                System.out.println(Thread.currentThread().getName());
                return s + "world";
            }
        }).thenApply(s -> s + "nice");
        System.out.println(future1.get());

        // 如果你不需要从回调函数中获取返回结果，可以使用 thenAccept() 或者 thenRun()
        // 两个方法的区别在于 thenRun() 不能访问异步计算的结果
        CompletableFuture<Void> future3 = CompletableFuture.completedFuture("hello").thenApply(s -> s + "123").thenAccept(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        CompletableFuture<Void> future4 = CompletableFuture.completedFuture("hello2").thenApply(s -> s + "321").thenRun(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()); //main
                System.out.println("thenRun");
            }
        });

        // whenComplete() 的方法的参数是 BiConsumer<? super T, ? super Throwable>，可以接收 2 个输入对象然后进行“消费”
        // 可以得到异常信息，但是无法修改返回结果
        CompletableFuture<String> future5 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return "hello!";
            }
        }).whenComplete(new BiConsumer<String, Throwable>() {
            @Override
            public void accept(String s, Throwable throwable) {
                System.out.println(Thread.currentThread().getName()); // main
                System.out.println(s);
            }
        });
        System.out.println(future5.get());

        // 你可以通过 handle() 方法来处理任务执行过程中可能出现的抛出异常的情况，可以修改返回结果
        CompletableFuture<String> future6 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println(Thread.currentThread().getName() + "supplyAsync"); // ForkJoinPool.commonPool-worker-1supplyAsync
                if (true) {
                    throw new RuntimeException("Computation error!");
                }
                return "hello";
            }
        }).handle((res, ex) -> res != null ? res : "null");
        System.out.println(future6.get());

        // 你还可以通过 exceptionally() 方法来处理异常情况
        CompletableFuture<String> future7 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println(Thread.currentThread().getName());
                throw new RuntimeException("Computation error!");
            }
        }, executor).exceptionally(new Function<Throwable, String>() {
            @Override
            public String apply(Throwable throwable) {
                System.out.println(throwable.toString());
                return "error";
            }
        });
        System.out.println(future7.get());

        // 你可以使用 thenCompose() 按顺序链接两个 CompletableFuture 对象
        // thenCompose() 可以两个 CompletableFuture 对象，并将前一个任务的返回结果作为下一个任务的参数，它们之间存在着先后顺序
        // thenCombine() 会在两个任务都执行完成后，把两个任务的结果合并。两个任务是并行执行的，它们之间并没有先后依赖顺序
        CompletableFuture<String> future8 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return "hello";
            }
        }, executor).thenCompose(new Function<String, CompletionStage<String>>() {
            @Override
            public CompletionStage<String> apply(String s) {
                return CompletableFuture.supplyAsync(new Supplier<String>() {
                    @Override
                    public String get() {
                        return s + "world";
                    }
                });
            }
        });
        System.out.println(future8.get());
        CompletableFuture<String> future9 = CompletableFuture.supplyAsync(() -> "hello!")
                .thenCombine(CompletableFuture.supplyAsync(() -> "world!"), (s1, s2) -> s1 + s2)
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + "nice!"));
        System.out.println(future9.get());
        executor.shutdown();

        // 你可以通过 CompletableFuture 的 allOf()这个静态方法来并行运行多个 CompletableFuture
        // allOf() 方法会等到所有的 CompletableFuture 都运行完成之后再返回
        // anyOf() 方法不会等待所有的 CompletableFuture 都运行完成之后再返回，只要有一个执行完成即可！
        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println(1);
                return "11";
            }
        });
        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println(2);
                return "22";
            }
        });
        CompletableFuture<Void> headerFuture = CompletableFuture.allOf(task1, task2);
        headerFuture.join();
        System.out.println(headerFuture.get());

    }

}
