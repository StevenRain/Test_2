package MutilThread;

public class ThreadSafety implements Runnable{

    private static volatile int i = 0;

    //The third method, static synchronized
    private static synchronized void increase () {
        i++;
    }

    @Override
    public void run() {
            for(int j=0;j<100000;j++) {
                increase();
            }
    }

    public static void main(String[] args) throws InterruptedException{
        ThreadSafety thread1 = new ThreadSafety();
        ThreadSafety thread2 = new ThreadSafety();
        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread2);

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
