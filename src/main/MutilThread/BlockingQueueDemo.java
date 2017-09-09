package MutilThread;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {

    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(3);

    private static Runnable readRunnable = () -> {
        while (true) {
            if(Thread.currentThread().isInterrupted()) {
                break;
            }

            try {
                Integer result = queue.take();
                System.out.println(result);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    private static Runnable writeRunnable = () -> {
        while (true) {
            if(Thread.currentThread().isInterrupted()) {
                break;
            }

            try {
                Integer number = new Random().nextInt(100);
                queue.add(number);
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    public static void main(String[] args) throws InterruptedException{
        Thread r1 = new Thread(readRunnable);
        Thread w1 = new Thread(writeRunnable);
        Thread w2 = new Thread(writeRunnable);

        w1.start();
        w2.start();
        r1.start();
    }
}
