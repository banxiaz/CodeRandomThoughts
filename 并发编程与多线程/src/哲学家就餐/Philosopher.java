package 哲学家就餐;

import java.util.concurrent.Semaphore;

public class Philosopher implements Runnable {
    public Semaphore[] semaphores;
    public int name;

    public Philosopher(Semaphore[] semaphores, int name) {
        this.semaphores = semaphores;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (name % 2 == 0) {
                try {
                    semaphores[name].acquire();
                    semaphores[(name + 1) % 5].acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    semaphores[(name + 1) % 5].acquire();
                    semaphores[name].acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("[" + Thread.currentThread().getName()+ "]" + name  + "正在就餐");
            semaphores[name].release();
            semaphores[(name + 1) % 5].release();
        }
    }
}
