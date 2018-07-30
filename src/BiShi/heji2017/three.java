package BiShi.heji2017;

import java.util.Scanner;

public class three {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        char[] c = s.toCharArray();
        int max = 0;
        int tmax = 1;
        for(int i =0;i < c.length-1;i++){
            if(c[i]!=c[i+1]){
                tmax++;
            }else {
                tmax = 1;
            }
            if(tmax > max){
                max = tmax;
            }
        }
        System.out.println(max);
    }
}
