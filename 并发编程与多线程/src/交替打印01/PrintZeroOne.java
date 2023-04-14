package 交替打印01;

import java.util.concurrent.Semaphore;

class Zero implements Runnable {
    Semaphore semaphore0;
    Semaphore semaphore1;

    public Zero(Semaphore semaphore0, Semaphore semaphore1) {
        this.semaphore0 = semaphore0;
        this.semaphore1 = semaphore1;
    }

    @Override
    public void run() {
        while (true) {
            try {
                semaphore1.acquire();
                System.out.print(0);
                Thread.sleep(1000);
                semaphore0.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class One implements Runnable {
    Semaphore semaphore0;
    Semaphore semaphore1;

    public One(Semaphore semaphore0, Semaphore semaphore1) {
        this.semaphore0 = semaphore0;
        this.semaphore1 = semaphore1;
    }

    @Override
    public void run() {
        while (true) {
            try {
                semaphore0.acquire();
                System.out.print(1);
                Thread.sleep(1000);
                semaphore1.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// 实现0101交替打印
public class PrintZeroOne {
    public static void main(String[] args) {
        Semaphore zero = new Semaphore(0);
        Semaphore one = new Semaphore(1);
        new Thread(new Zero(zero, one)).start();
        new Thread(new One(zero, one)).start();
    }
}
