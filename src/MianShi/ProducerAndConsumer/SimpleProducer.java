package MianShi.ProducerAndConsumer;

import java.util.concurrent.BlockingQueue;

public class SimpleProducer implements Runnable {
    BlockingQueue<String> queue;

    public SimpleProducer(BlockingQueue queue){
        this.queue = queue;
    }


    @Override
    public void run() {
        try {
            String temp = "A Product. 生产线程:" + Thread.currentThread().getName();
            System.out.println("我制造了一个产品:" + Thread.currentThread().getName());
            queue.put(temp);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
