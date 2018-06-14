package MianShi.ProducerAndConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class SimperBQTest {

    public static void main(String[] args) {
        BlockingQueue<String > queue = new LinkedBlockingDeque<String>(2);

        SimpleConsumer consumer = new SimpleConsumer(queue);
        SimpleProducer producer = new SimpleProducer(queue);
        for(int i = 0; i< 5;i++){
            new Thread(producer,"Product" + (i+1)).start();
            new Thread(consumer,"Consumer" + (i+1)).start();

        }

    }
}
