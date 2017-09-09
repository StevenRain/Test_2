package MutilThread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo implements Runnable {

    private static CountDownLatch countDown = new CountDownLatch(10);
    private static CountDownLatchDemo demo = new CountDownLatchDemo();

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(5) * 1000);
            System.out.println("Check completed!");
            countDown.countDown();
        }catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i=0;i<10;i++) {
            service.submit(demo);
        }
        countDown.await();
        System.out.println("Fire");
        service.shutdown();
    }
}
