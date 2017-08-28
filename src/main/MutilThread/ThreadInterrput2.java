package MutilThread;

public class ThreadInterrput2 {

    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if(Thread.currentThread().isInterrupted()) {
                        System.out.println("Interrupted");
                        break;
                    }
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e) {
                        System.out.println("Interrupted when sleep");
                        Thread.currentThread().interrupt();
                    }
                    Thread.yield();
                }
            }
        };

        t1.start();
        Thread.sleep(500);
        t1.interrupt();
    }
}
