package MutilThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCondition implements Runnable {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    @Override
    public void run() {
        try {
            lock.lock();
            condition.await();
            System.out.println("Thread is going on");
        }catch (InterruptedException ie) {
            ie.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockCondition reentrantLockCondition = new ReentrantLockCondition();
        Thread t1 = new Thread(reentrantLockCondition);

        t1.start();
        Thread.sleep(2000);

        lock.lock();
        condition.signal();
        lock.unlock();
    }
}
