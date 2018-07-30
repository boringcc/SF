package BiShi.heji2017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class heji_second {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int d = 0;
        int n = in.nextInt();
        int[] a = new int[n];
        int sum = 0;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for(int i = 0;i <n ;i++){
            int tem = in.nextInt();
            arrayList.add(tem);
            sum+=tem;
        }

        Collections.sort(arrayList);
        if((arrayList.get(2) - arrayList.get(1))==(arrayList.get(1)-arrayList.get(0))){
            d=arrayList.get(2) - arrayList.get(1);
            if(sum == (n*arrayList.get(0)+(n*(n-1))*d/2)){
                System.out.println("Possible");
            }else {
                System.out.println("Impossible");
            }
        }else {
            System.out.println("Impossible");
        }

    }

}
