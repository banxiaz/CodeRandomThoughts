package ThreadPoolExecutorDemo;

import java.util.Date;
import java.util.concurrent.*;

public class ThreadPoolParameter {
    public static void main(String[] args) {
        // int corePoolSize 线程池的核心线程数量，最小可以同时运行的线程数量，初始化的时候就创建了这么多个线程
        // int maximumPoolSize 线程池的最大线程数
        // long keepAliveTime 当线程数大于核心线程数时，多余的空闲线程存活的最长时间
        // TimeUnit unit 时间单位
        // BlockingQueue<Runnable> workQueue 任务队列，用来储存等待执行任务的队列，当新任务来的时候会先判断当前运行的线程数量是否达到核心线程数，如果达到的话，新任务就会被存放在队列中
        // ThreadFactory threadFactory 线程工厂，用来创建线程，一般默认即可
        // RejectedExecutionHandler handler 拒绝策略，当提交的任务过多而不能及时处理时，我们可以定制策略来处理任务

        /*ThreadPoolExecutor.AbortPolicy ：抛出 RejectedExecutionException来拒绝新任务的处理。
        ThreadPoolExecutor.CallerRunsPolicy ：调用执行自己的线程运行任务，也就是直接在调用execute方法的线程中运行(run)被拒绝的任务，如果执行程序已关闭，则会丢弃该任务。因此这种策略会降低对于新任务提交速度，影响程序的整体性能。如果您的应用程序可以承受此延迟并且你要求任何一个任务请求都要被执行的话，你可以选择这个策略。
        ThreadPoolExecutor.DiscardPolicy ：不处理新任务，直接丢弃掉。
        ThreadPoolExecutor.DiscardOldestPolicy ： 此策略将丢弃最早的未处理的任务请求*/

        /*初始化线程池，刚开始没有线程但可以预热，准备接受任务；
        新的任务进来，新建线程，分配给core中空闲线程；
        1）core满了，后面进来的任务就会进入到阻塞队列中；当有空闲的core时，就会去阻塞队列中获取；
        2）当阻塞队列也满了，此时就会直接创建新的线程，但是线程池总线程数不能超过max；
        3）max都执行好了，max-core数量的空闲线程就会在keepAliveTime指定的时间自动释放，最后保持到core的大小；
        4）如果线程数开到了max大小，此时再有新的任务进来，那么就会使用相应的拒绝策略进行处理；
        所有的线程创建都是由指定的 factory 创建的。*/

        /*一个线程池 coreSize=7； maxSize=20 ，workQueen=50，有100并发量进来怎么分配的？
        先有 7 个能直接得到执行，接下来 50 个进入阻塞队列排队，再多开 13 个继续执行。现在 70 个被安排上了。剩下30个默认拒绝策略。*/

        // CPU 密集型任务(N+1)I/O 一旦任务暂停，CPU 就会处于空闲状态，而在这种情况下多出来的一个线程就可以充分利用 CPU 的空闲时间
        // I/O 密集型任务(2N)，线程在处理 I/O 的时间段内不会占用 CPU 来处理，可以多配置一些线程
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                5,
                10,
                1,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
            });
        }
        //终止线程池
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}
