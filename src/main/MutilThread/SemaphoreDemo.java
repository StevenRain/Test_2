package MutilThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo implements Runnable {
    private static final Semaphore sem = new Semaphore(5);

    @Override
    public void run() {
        try{
            sem.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId() + " done");
            sem.release();
        }catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);
        SemaphoreDemo demo = new SemaphoreDemo();
        for(int i=0;i<20;i++) {
            service.submit(demo);
        }
        service.shutdown();
    }
}
