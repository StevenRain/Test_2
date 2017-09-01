package MutilThread;

public class DaemonThread {
    private static class DeamonT extends Thread {
        @Override
        public void run() {
            while (true) {
                if(Thread.currentThread().isInterrupted()) {
                    break;
                }

                System.out.println("I am alive");
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Thread t = new DeamonT();
        t.setDaemon(true);
        t.start();

        Thread.sleep(2000);
    }
}
