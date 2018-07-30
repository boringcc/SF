package BiShi.heji2017;

import java.util.Scanner;

public class five {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int f = in.nextInt();
        int d = in.nextInt();
        int p = in.nextInt();
        if(x*f > d){
            System.out.println(d/x);
        }else {
            System.out.println(((d-x*f)/(p+x))+f);
        }
    }
}
