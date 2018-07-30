package test;

import SFShiYang.TSP;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.*;

public class Test {

    private static int hash(int h) {
        h += (h << 15) ^ 0xffffcd7d; h ^= (h >>> 10);
        h += (h << 3); h ^= (h >>> 6);
        h += (h << 2) + (h << 14); return h ^ (h >>> 16);
    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("0001111", 2));
        System.out.println(Integer.parseInt("0011111", 2) );
        System.out.println(4 & 15);
    }
}

