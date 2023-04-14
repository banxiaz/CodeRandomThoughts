package CompletableFutureDemo;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletableFuture2 {
    /*FutureTask能很好的应用于有返回的异步调用；但是如果出现如下需求时则显得捉襟见肘：
    - 无法手动完成：当调用远程服务时，如果发现远程服务出现问题，你需要将最近一次正常结果返回；这时使用Future就无法满足该需求。
    - 无法添加回调方法：当调用远程服务结束后需要调用其它方法时，如果使用Future，则需要不断循环调用isDone方法判断是否完成；然后调用get获得结果，接着调用其它方法。
    - 无法将多任务合并获得结果：当需要并行调用多个远程服务时，在获得返回结果时需要不断循环调用各future的isDone方法。
    - 没有异常处理：Future API没有提供异常处理方法。*/

    // Future只是一个接口，提供了一些管理异步调用和获取值的方法
    // FutureTask同时实现了Future和Runnable接口，同时构造函数接收Callable和Runnable类型，既可以当作任务执行，又可以获取结果值
    //
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(Thread.currentThread().getName() + "main");
        CompletableFuture<Void> future = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "runAsync");
            }
        }); // 需要异步操作且不关心返回结果
        System.out.println(future.get());

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println(Thread.currentThread().getName() + "supplyAsync");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "supplyAsync";
            }
        });
        System.out.println(future1.get());

    }

}
