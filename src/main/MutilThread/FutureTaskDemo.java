package MutilThread;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.concurrent.*;

public class FutureTaskDemo implements Callable<Integer>{

    private Integer getIntegerValue() {
        return 100;
    }

    @Override
    public Integer call() throws Exception {
        return getIntegerValue();
    }

    public static void test() throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Integer> future = service.submit(new FutureTaskDemo());
        Thread.sleep(200);
        service.shutdown();
        int value = future.get();
        System.out.println(value);
    }

    public static void main(String[] args) throws Exception{
        FutureTask<Integer> future = new FutureTask(new FutureTaskDemo());
        future.run();
        Thread.sleep(200);
        int value = future.get();
        System.out.println(value);

        test();
    }
}
