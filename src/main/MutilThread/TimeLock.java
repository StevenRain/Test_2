package MutilThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TimeLock implements Runnable {
    private static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            if(Thread.currentThread().isInterrupted()) {
                break;
            }
            try{
                if(lock.tryLock(1, TimeUnit.SECONDS)) {
                    System.out.println("current thread is " + Thread.currentThread().getName());
                    Thread.sleep(2000);
                    Thread.currentThread().interrupt();
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        TimeLock timeLock = new TimeLock();
        Thread t1 = new Thread(timeLock, "thread-t1");
        Thread t2 = new Thread(timeLock, "thread-t2");
        Thread t3 = new Thread(timeLock, "thread-t3");
        t1.start();
        t2.start();
        t3.start();
    }
}