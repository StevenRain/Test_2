package MutilThread;

import java.util.ArrayList;
import java.util.Vector;

public class ArrayListMultiThread {

    private static Vector<Integer> a1 = new Vector<>(10);
    private static Object object = new Object();

    public static class AddThread implements Runnable {
        @Override
        public void run() {
            for(int i=0;i<1000000;i++) {
                a1.add(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddThread r1 = new AddThread();
        AddThread r2 = new AddThread();

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(a1.size());
    }
}
