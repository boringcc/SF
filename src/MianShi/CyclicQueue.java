package MianShi;

public class CyclicQueue {
    private int[] queue = null;
    private int head;
    private int tail;
    private int len;

    public CyclicQueue(int len){
        this.len = len;
        queue = new int[len];
    }

    private void push(int x){
        if(isFull()){
            System.out.println("队列已满，入队失败");
        }else {
            queue[tail] = x;

            tail = (tail + 1)% len;
        }
    }


    private int pop(){
        if(isNull()){
            System.out.println("队列为空");
            return -1;
        }else {
            int n = queue[head];

            head = (head +1)%len;
            return n;
        }
    }


    private int head(){
        return queue[head];
    }

    private int tail(){
        return queue[(tail + len -1)%len];
    }


    private boolean isFull(){
        if((tail + 1) % len == head){
            return true;
        }else {
            return false;
        }
    }

    private boolean isNull(){
        if (head == tail){
            return true;
        }else {
            return false;
        }
    }



}
