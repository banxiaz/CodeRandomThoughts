package 生产者消费者;

import java.util.List;
import java.util.Random;

public class Producer implements Runnable {
    public List<Integer> list;
    public int maxLength;

    public Producer(List<Integer> list, int len) {
        this.list = list;
        maxLength = len;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                while (list.size() == maxLength) {
                    System.out.println(Thread.currentThread().getName() + "容量已满");
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int i = new Random().nextInt();
                list.add(i);
                System.out.println(Thread.currentThread().getName() + "生产者生产了产品：" + i);
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
