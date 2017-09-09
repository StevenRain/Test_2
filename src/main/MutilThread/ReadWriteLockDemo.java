package MutilThread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo{
    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private static Integer sharedData = null;

    private static Runnable readRunnable = () -> {
        while (true) {
            reentrantReadWriteLock.readLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + " read " + sharedData);
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantReadWriteLock.readLock().unlock();
        }
    };

    private static Runnable writeRunnable = () -> {
        reentrantReadWriteLock.writeLock().lock();
        try {
            sharedData = new Random().nextInt(100);
            System.out.println(Thread.currentThread().getName() + " write " + sharedData);
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        reentrantReadWriteLock.writeLock().unlock();
    };


    public static void main(String[] args) throws InterruptedException{
        Thread r1 = new Thread(readRunnable, "R1");
        Thread r2 = new Thread(readRunnable, "R2");
        Thread r3 = new Thread(readRunnable, "R3");
        Thread w1 = new Thread(writeRunnable, "W1");
        Thread w2 = new Thread(writeRunnable, "W2");

        w1.start();
        w1.join();
        r1.start();
        r2.start();
        r3.start();
        w2.start();
    }
}