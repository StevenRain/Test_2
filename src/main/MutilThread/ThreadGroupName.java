package MutilThread;

import java.text.MessageFormat;

public class ThreadGroupName implements Runnable{
    @Override
    public void run() {
        String groupAndName = Thread.currentThread().getThreadGroup().getName() +
                "-" + Thread.currentThread().getName();

        while(true) {
            if(Thread.currentThread().isInterrupted()) {
                break;
            }
            System.out.println(MessageFormat.format("I am {0}", groupAndName));
            try{
                Thread.sleep(3000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("PrintGroup");
        Thread t1 = new Thread(threadGroup, new ThreadGroupName(), "T1");
        Thread t2 = new Thread(threadGroup, new ThreadGroupName(), "T2");
        t1.start();
        t2.start();
        t1.interrupt();
        System.out.println(threadGroup.activeCount());
//        threadGroup.list();
    }
}
