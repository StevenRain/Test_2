package MutilThread;

import java.util.concurrent.locks.ReentrantLock;

public class FairLock implements Runnable {

    public static ReentrantLock fairLock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            if(Thread.currentThread().isInterrupted()) {
                break;
            }

            try {
                fairLock.lock();
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " get lock");
            }catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                fairLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        FairLock r = new FairLock();
        Thread t1 = new Thread(r, "T1");
        Thread t2 = new Thread(r, "T2");
        t1.start();
        t2.start();
    }
}
