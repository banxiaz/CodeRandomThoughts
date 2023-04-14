package 哲学家就餐;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore[] semaphores = new Semaphore[5];
        for (int i = 0; i < 5; i++) {
            semaphores[i] = new Semaphore(1);
        }
        Philosopher philosopher0 = new Philosopher(semaphores, 0);
        Philosopher philosopher1 = new Philosopher(semaphores, 1);
        Philosopher philosopher2 = new Philosopher(semaphores, 2);
        Philosopher philosopher3 = new Philosopher(semaphores, 3);
        Philosopher philosopher4 = new Philosopher(semaphores, 4);

        new Thread(philosopher0).start();
        new Thread(philosopher1).start();
        new Thread(philosopher2).start();
        new Thread(philosopher3).start();
        new Thread(philosopher4).start();
    }
}
