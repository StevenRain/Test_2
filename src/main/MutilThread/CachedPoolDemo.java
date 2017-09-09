package MutilThread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class CachedPoolDemo {

    private static Consumer<Thread> delayOneSeconds = t -> {
        try {
            t.sleep(3000);
        }catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    };

    private static Runnable printTime = () -> {
        LocalDateTime localDateTime = LocalDateTime.now();
        String pattern = "yyyy-MM-dd HH:mm:ss";
        String time = localDateTime.format(DateTimeFormatter.ofPattern(pattern));
        System.out.println(time);
        delayOneSeconds.accept(Thread.currentThread());
    };

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        service.scheduleAtFixedRate(printTime, 0, 2, TimeUnit.SECONDS);
    }
}
