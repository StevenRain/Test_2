package MutilThread;

import sun.awt.windows.ThemeReader;

import java.util.Random;
import java.util.concurrent.*;

public class CyclicBarrierDemo {

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

    private static Runnable runnable = () -> {
        try {
            cyclicBarrier.await();
            Thread.sleep(new Random().nextInt(5) * 1000);
            System.out.println(Thread.currentThread().getName() + " done!");
            cyclicBarrier.await();
        }catch (Exception e) {
            e.printStackTrace();
        }
    };

    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(10);
        CyclicBarrierDemo demo = new CyclicBarrierDemo();
        for(int i=0;i<10;i++) {
            service.submit(runnable);
        }
        cyclicBarrier.await();
        System.out.println("All services done!");
        service.shutdown();
    }
}
