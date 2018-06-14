package MianShi.ProducerAndConsumer;

import java.util.concurrent.BlockingQueue;

public class SimpleConsumer implements Runnable{
    BlockingQueue<String> queue;

    public SimpleConsumer(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            String temp = queue.take();
            System.out.println("消费者：" +temp);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
