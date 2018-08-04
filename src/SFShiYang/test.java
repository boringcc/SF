package SFShiYang;

import org.junit.Test;

import java.util.*;

public class test {

    public static void quickSort(int[] a,int start,int end){
        Stack<Integer> stack = new Stack<Integer>();
        if(start < end){
            stack.push(end);
            stack.push(start);
            while (!stack.isEmpty()){
                int l = stack.pop();
                int r = stack.pop();
                int index = partition(a,l,r);
                if(l < index -1){
                    stack.push(index-1);
                    stack.push(l);
                }

                if(r > index + 1){
                    stack.push(r);
                    stack.push(index + 1);
                }
            }
        }
    }


    public static int partition(int[] a,int low,int hi){
        int pivot = a[low];
        while (low < hi){
            while (low < hi && a[hi] >= pivot){
                hi--;
            }
            a[low] = a[hi];
            while (low < hi && a[low] <= pivot){
                low++;
            }
            a[hi] = a[low];
        }
        a[low] = pivot;
        return low;
    }

    public static void main(String[] args) {



    }




}
