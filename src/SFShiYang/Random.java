package SFShiYang;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Random {

    public static long seed;

    public  void setSeed(int sd){
        seed = sd;
    }

    //N(i+1) = (A * Ni + B)%M
    public  long rand(){
        //seed = (seed * 9301 + 49297)%((1 << 15) - 1);
        //a = 1664525 c = 1013904223 m = 2^32     6310

        /**
         * 1.B，M互为质数
         2.M的所有质因子的积能整除A-1
         3.若M是4的倍数，A-1也是
         4.A,B,N0都比M小
         5.A,B是正整数
         */

        //a = 22695477  c = 1 m = 2^32            6297
        //a = 22695477  c = 2 m = 2^32            4314      测试c和m互为质数
        //a = 22695477  c = 1 m = 2^32-1          5711      测试m是4的倍数
        //a = 22695478  c = 1 m = 2^32            30        测试a-1是否为4的倍数
        //a = -22695477  c = -1 m = 2^32                    测试a，c为正数，结果是产生的随机数为负
        //a = 22695477  c = 1 m =  20             4         测试a比m大，随机数重复概率特别高

        //a = 1103515245  c = 12345 m = 2^32      6308

        //a = 134775813   c = 1 m = 2^32          6346
        //a = 134775813   c = 2 m = 2^32          4309      测试c和m互为质数
        //a = 134775813   c = 1 m = 2^32-1        5647      测试m是4的倍数
        //a = 134775814   c = 1 m = 2^32          31        测试a-1是否为4的倍数

        long a = 22695477;
        long c = 1;
        long m = (long)Math.pow(2,32);
        seed = (seed * a + c)%m;
        return seed;
    }



    public static void main(String[] args) throws IOException {
        Random random = new Random();

        random.setSeed(5);

        List<String> testList = new ArrayList<String>();
        File file = new File("E:\\test\\random.txt");
        String test = null;
        BufferedReader br = new BufferedReader(new FileReader(file));
        while ((test = br.readLine())!=null){
            testList.add(test);
        }
        for(int j = 0;j<testList.size();j++) {
            test = testList.get(j);
            br.close();
            String[] a = test.split(" ");
            int[] b = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                b[i] = Integer.parseInt(a[i]);
            }
            int n = b[0];   // 随机数个数
            int min = b[1]; //随机数范围最小值（即左边界）
            int max = b[2]; //随机数范围最大值（即右边界）
            Set<Long> test1 =  new HashSet<>();
            System.out.println("第" + (j+1) + "个样例产生的随机数序列如下：");
            for (int i = 0; i < n; i++) {
                long x = random.rand();
                long y = x%(max - min) + min;
                test1.add(y);
                System.out.print(y + " ");
                if (i % 50 >= 49) {
                    System.out.println();
                }
            }
            System.out.println();
            System.out.println(test1.size());
        }


    }




}
