package BiShi.wangYi2017neiTui;

import java.util.LinkedList;
import java.util.Scanner;

public class one {
    LinkedList<Integer> queue = new LinkedList<Integer>();
    LinkedList<Integer> left = new LinkedList<Integer>();
    LinkedList<Integer> right = new LinkedList<Integer>();

    public void getQueue(int[] a,int k){
        for(int m = 0;m < a.length;m++){
            queue.addLast(a[m]);
        }
        for(int p = 0;p < k;p++) {
            for (int i = 0; i < a.length / 2; i++) {
                left.addLast(queue.pollFirst());
            }
            for (int j = a.length / 2; j < a.length; j++) {
                right.addLast(queue.pollFirst());
            }

            for(int o = 1;o<=a.length;o++){
                if (o%2==0){
                    queue.addLast(right.pollFirst());
                }else {
                    queue.addLast(left.pollFirst());
                }
            }
        }

    }

    public static void main(String[] args) {
        one test = new one();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int n1 = 0;n1 < n ;n1++) {
            int k1 = in.nextInt();
            int k2 = in.nextInt();
            int[] a = new int[2*k1];
            for(int n2 = 0; n2 < 2*k1;n2 ++){
                a[n2] = in.nextInt();
            }
            test.getQueue(a, k2);
            for (int i = 0; i < a.length; i++) {
                System.out.print(test.queue.pollFirst());
                if (i != a.length-1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }


    }


}
