package BiShi.heji2017;

import java.util.LinkedList;
import java.util.Scanner;

public class four {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i =0;i < n;i++){
            a[i] = in.nextInt();
        }
        if(n %2 ==0){
        for(int j = 0;j < n;j++){
            if(j%2 == 0){
                list.addLast(a[j]);
            }else {
                list.addFirst(a[j]);
            }
        }
        }else {
            for(int j = 0;j < n;j++){
                if(j%2 == 1){
                    list.addLast(a[j]);
                }else {
                    list.addFirst(a[j]);
                }
            }
        }
        for(int x = 0; x < n;x++){
            System.out.print(list.pollFirst());
            if(x != n-1){
                System.out.print(" ");
            }
        }
    }

}
