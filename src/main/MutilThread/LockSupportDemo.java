package MutilThread;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LockSupportDemo {
    private static ReentrantLock lock = new ReentrantLock();

    public static class ChangeObject extends Thread {
        public ChangeObject(String name) {
            super(name);
        }

        @Override
        public void run() {
            lock.lock();
            System.out.println("in " + getName());
            LockSupport.park();
            lock.unlock();
        }
    }

    public static void main(String[] args) throws Exception{
        Thread t1 = new ChangeObject("t1");
        Thread t2 = new ChangeObject("t2");
        t1.start();
        Thread.sleep(1000);
        t2.start();
        LockSupport.unpark(t1);
        LockSupport.unpark(t2);
        t1.join();
        t2.join();
    }
}
