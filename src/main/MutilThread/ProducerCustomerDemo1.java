package MutilThread;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ProducerCustomerDemo1 {
    private static BlockingQueue<MyData> myData = new LinkedBlockingDeque<>(5);
    private static ThreadLocal<Random> random = new ThreadLocal<>();

    @AllArgsConstructor
    @Data
    private static class MyData {
        private Integer value;
    }

    private static class Producer implements Runnable{

        @Override
        public void run() {
            if(random.get() == null) {
                random.set(new Random());
            }

            while (true) {
                if(Thread.currentThread().isInterrupted()) {
                    break;
                }
                MyData data = new MyData(random.get().nextInt(100));
                try {
                    myData.put(data);
                    System.out.println("Produced " + data.getValue());
                    Thread.sleep(random.get().nextInt(1000));
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Customer implements Runnable {
        @Override
        public void run() {
            if(random.get() == null) {
                random.set(new Random());
            }
            while (true) {
                if(Thread.currentThread().isInterrupted()) {
                    break;
                }
                try {
                    MyData data = myData.take();
                    System.out.println("Get " + data.getValue());
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Customer customer = new Customer();
        Producer producer = new Producer();
        Thread customer1 = new Thread(customer, "customer1");
        Thread customer2 = new Thread(customer, "customer2");
        Thread producer1 = new Thread(producer, "producer1");
        Thread producer2 = new Thread(producer, "producer2");

        customer1.start();
        customer2.start();
        producer1.start();
        producer2.start();
    }
}
