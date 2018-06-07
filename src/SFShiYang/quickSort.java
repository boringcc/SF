package SFShiYang;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class quickSort {
public static int count=0;

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        if(lo != j-1 && j+1!=hi) {
            sort(a, lo, j - 1);
            sort(a, j + 1, hi);
        }
    }

    private static int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        exch(a,lo,(int)(Math.random()*(hi - lo + 1)+lo));
        count++;
        int v = a[lo];
        while (true) {
            while (less(a[++i], v)) {
                count++;
                if (i == hi) {
                    break;
                }
            }
            while (less(v, a[--j])) {
                count++;
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        if(lo != j){
        exch(a, lo, j);
        }
        return j;
    }

    public static void quick_sort(int[] a) {
        quick_sort(a, 0, a.length - 1);
    }

    public static void quick_sort(int a[],int lo,int hi){
        if(lo < hi){
            int i = lo;
            int j = hi;
            exch(a,lo,(int)(Math.random()*(hi - lo + 1)+lo));
            count++;
            int temp = a[lo];
            while (i < j){
                while (i < j && a[j] > temp){
                    j--;
                    count++;
                }
                if (i < j){
                    a[i] = a[j];
                    i++;
                    count++;
                }
                while (i < j && a[i] < temp){
                    i++;
                    count++;
                }
                if(i < j){
                    a[j] = a[i];
                    j--;
                    count++;
                }
            }
            a[i] = temp;
            count++;
            quick_sort(a,lo,i-1);
            quick_sort(a,i+1,hi);
        }
    }



    //判断是否前一个比后一个小
    public static boolean less(int v, int w) {
        if(v <= w){
            return true;
        }else {
            return false;
        }
    }
    //交换
    public static void exch(int[] a, int i, int j) {
        count = count+3;
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

        List<String> testList = new ArrayList<String>();
        File file = new File("E:\\test\\quick.txt");
        String test = null;
        BufferedReader br = new BufferedReader(new FileReader(file));
        while ((test = br.readLine())!=null){
            testList.add(test);
        }
        for(int j = 0;j<testList.size();j++) {
            test = testList.get(j);
            br.close();
            String[] a = test.split(",");
            int[] b = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                b[i] = Integer.parseInt(a[i]);
            }

            sort(b);

            System.out.println("第 " + j +" 组样例交换次数:" + count +" 数组本身长度 " + a.length);
            for (int i = 0; i < a.length; i++) {
                System.out.print(b[i]);
                System.out.print(",");
            }
            System.out.println();
            count=0;
        }


    }

}
