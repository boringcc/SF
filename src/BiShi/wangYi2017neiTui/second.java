package BiShi.wangYi2017neiTui;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class second {
    LinkedList<Integer> queue = new LinkedList<Integer>();

    public  void getQueue(int x){
        for(int i = x;i > 0;i--){
            queue.addFirst(i);
            int tem = queue.removeLast();
            queue.addFirst(tem);
        }
    }

    public static void main(String[] args) {
        second test = new second();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int j = 0;j < n ;j++) {
            int x = in.nextInt();
            test.getQueue(x);
            for (int i = 0; i < x; i++) {
                System.out.print(test.queue.pop());
                if (i != x-1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }



}
