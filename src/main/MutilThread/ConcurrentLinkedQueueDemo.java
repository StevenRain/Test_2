package MutilThread;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentLinkedQueueDemo {
    private static ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
    private static AtomicInteger i = new AtomicInteger();

    private static Runnable writeRunnable = () -> {
        Thread.currentThread().setName("读线程");
        for(int i=0;i<10000;i++) {
            queue.add(i);
        }
        System.out.println(Thread.currentThread().getName() + " 完成");
    };

    private static Runnable readRunnable = () -> {
        while (true) {
            Integer result = queue.poll();
            if(result == null) {
                break;
            }
            i.incrementAndGet();
            try {
                Thread.sleep(1);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(writeRunnable);
        Thread t2 = new Thread(readRunnable, "t2");
        Thread t3 = new Thread(readRunnable, "t3");
        Thread t4 = new Thread(readRunnable, "t4");
        Thread t5 = new Thread(readRunnable, "t5");
        Thread t6 = new Thread(readRunnable, "t6");
        Thread t7 = new Thread(readRunnable, "t7");
        Thread t8 = new Thread(readRunnable, "t8");
        Thread t9 = new Thread(readRunnable, "t9");
        Thread t10 = new Thread(readRunnable, "t10");
        Thread t11 = new Thread(readRunnable, "t11");
        long startTime = System.currentTimeMillis();
        t1.start();
        t1.join();

        i.set(0);

        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
        t11.start();

        t2.join();
        t3.join();
        t4.join();
        t5.join();
        t6.join();
        t7.join();
        t8.join();
        t9.join();
        t10.join();
        t11.join();
        System.out.println(i.get());
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
