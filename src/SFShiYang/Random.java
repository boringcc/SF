package SFShiYang;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Random {

    public static int seed;

    public  void setSeed(int sd){
        seed = sd;
    }

    //N(i+1) = (A * Ni + B)%M
    public  int rand(){
        seed = (seed * 9301 + 49297)%((1 << 15) - 1);
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
            Set<Integer> test1 =  new HashSet<>();
            System.out.println("第" + (j+1) + "个样例产生的随机数序列如下：");
            for (int i = 0; i < n; i++) {
                int x = random.rand();
                int y = x%(max - min) + min;
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
