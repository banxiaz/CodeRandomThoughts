package 生产者消费者;

import java.util.List;

public class Consumer implements Runnable {
    public List<Integer> list;
    public int maxLength;

    public Consumer(List<Integer> list, int len) {
        this.list = list;
        maxLength = len;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                while (list.isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + "容量空了");
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Integer element = list.remove(0);
                System.out.println(Thread.currentThread().getName() + "消费者消费了产品：" + element);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.notifyAll();
            }
        }
    }
}
