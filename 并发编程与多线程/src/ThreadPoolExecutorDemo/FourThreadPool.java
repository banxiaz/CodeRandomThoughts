package ThreadPoolExecutorDemo;

public class FourThreadPool {
    // FixedThreadPool 被称为可重用固定线程数的线程池
    // SingleThreadExecutor 是只有一个线程的线程池
    // CachedThreadPool 是一个会根据需要创建新线程的线程池，核心数默认为0
    // ScheduledThreadPoolExecutor 主要用来在给定的延迟后运行任务，或者定期执行任务

    // FixedThreadPool 和 SingleThreadExecutor ： 允许请求的队列长度为 Integer.MAX_VALUE，可能堆积大量的请求，从而导致 OOM。
    // CachedThreadPool 和 ScheduledThreadPool ： 允许创建的线程数量为 Integer.MAX_VALUE，可能会创建大量线程，从而导致 OOM。
}
