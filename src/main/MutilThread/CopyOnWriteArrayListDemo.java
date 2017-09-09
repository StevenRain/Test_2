package MutilThread;

import com.google.common.collect.Lists;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class CopyOnWriteArrayListDemo {

    private static AtomicInteger i = new AtomicInteger(0);
    private static CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

    private static Runnable readRunnable = () -> {
        Integer result = list.get(i.get());
        i.incrementAndGet();
        System.out.println(result);
    };

    private static Runnable writeRunnable = () -> {
        list.add(new Random().nextInt(100));
    };

    public static void main(String[] args) throws InterruptedException{
        Thread read1 = new Thread(readRunnable);
        Thread read2 = new Thread(readRunnable);
        Thread write1 = new Thread(writeRunnable);
        Thread write2 = new Thread(writeRunnable);

        write1.start();
        write2.start();
        write1.join();
        write2.join();

        read1.start();
        read2.start();
    }
}
