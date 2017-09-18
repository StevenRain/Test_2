package MutilThread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JstackDemo {

    private static Runnable runnable = () -> {
        while (true) {
            if(Thread.currentThread().isInterrupted()) {
                break;
            }
            try {
                String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                System.out.println(time);
                Thread.sleep(2000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    public static void main(String[] args) {
        Thread t1 = new Thread(runnable, "Steven-T1");
        t1.start();
    }
}
