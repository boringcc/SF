package SFShiYang;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class quickSort {

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        exch(a,lo,(int)(Math.random()*(hi - lo + 1)+lo));
        int v = a[lo];
        while (true) {
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }


    //判断是否前一个比后一个小
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    //交换
    public static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void createEx(int size,List<Integer> tofile) throws IOException {
        FileWriter fileWriter=new FileWriter("E:\\text.txt");
        Random rand = new Random(100);
        for (int i = 100; i >0; i--) {
            fileWriter.write(String.valueOf(i));
            fileWriter.write("\n");
        }
        fileWriter.flush();
        fileWriter.close();
    }


    public static void main(String[] args) throws IOException {

        int size = 60;
        List<Integer> toFile = new ArrayList();
        for(int x = 0 ; x < size ;x++){
            toFile.add(x);
        }
        createEx(size,toFile);
        File file = new File("E:\\text.txt");

        BufferedReader in = new BufferedReader(new FileReader(file));
        String line = null;
        int row = 0;

        List read =new ArrayList();
        int i = 0;
        while ((line = in.readLine())!=null){
            read.add(line);
            i++;
        }
        int[] a = new int[i];


        for(int j=0;j < a.length ; j++){
            a[j] = (int) read.get(j);
            System.out.println(a[j]);
        }
        Long time1 = System.currentTimeMillis();
        sort(a);
        Long time2 = System.currentTimeMillis();
        System.out.println("数组求和所花费时间：" + (time2 - time1) + "毫秒");

        System.out.println("------------");
        for(int j=0;j < a.length ; j++){
            System.out.println(a[j]);
        }
        in.close();
    }




}
