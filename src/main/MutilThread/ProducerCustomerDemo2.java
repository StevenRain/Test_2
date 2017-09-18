package MutilThread;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ProducerCustomerDemo2 {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class PCData {
        private long value;
    }

    private static class PCDataFactory implements EventFactory<PCData> {
        @Override
        public PCData newInstance() {
            return new PCData();
        }
    }

    private static class Consumer implements WorkHandler<PCData> {
        @Override
        public void onEvent(PCData pcData) throws Exception {
            System.out.println(Thread.currentThread().getName() + " get data "  + pcData.getValue() + " --------------");
        }
    }

    private static class Producer{
        private final RingBuffer<PCData> ringBuffer;

        public Producer(RingBuffer<PCData> ringBuffer) {
            this.ringBuffer = ringBuffer;
        }

        public void pushData(long value) {
            long sequence = ringBuffer.next();
            try {
                PCData pcData = ringBuffer.get(sequence);
                pcData.setValue(value);
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                ringBuffer.publish(sequence);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Executor executor = Executors.newCachedThreadPool();
        PCDataFactory factory = new PCDataFactory();
        int bufferSize = 128;

        Disruptor<PCData> disruptor = new Disruptor<PCData>(factory,
                bufferSize,
                executor,
                ProducerType.MULTI,
                new SleepingWaitStrategy()
        );

        disruptor.handleEventsWithWorkerPool(
                new Consumer(),
                new Consumer(),
                new Consumer(),
                new Consumer()
        );

        disruptor.start();

        RingBuffer<PCData> ringBuffer = disruptor.getRingBuffer();
        Producer producer = new Producer(ringBuffer);
        long value = 1;
        while (value ++ > 0) {
            producer.pushData(value);
            Thread.sleep(100);
            System.out.println("add data " + value + " ******************");
        }
    }
}
