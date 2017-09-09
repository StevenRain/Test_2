package MutilThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExtThreadPool{

    private static class MyTask implements Runnable{
        private String name;

        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(String.format("正在执行 Thread ID: %d, Task Name: %s", Thread.currentThread().getId(), name));
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>()) {
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println(String.format("准备执行：%s", ((MyTask) r).name));
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println(String.format("执行完成：%s", ((MyTask) r).name));
            }

            @Override
            protected void terminated() {
                System.out.println("线程池退出");
            }
        };

        for(int i=0;i<5;i++) {
            MyTask task = new MyTask("TASK-" + i);
            service.execute(task);
            Thread.sleep(10);
        }
        service.shutdown();
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
