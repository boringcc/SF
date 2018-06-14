package test;

import SFShiYang.TSP;

import java.util.Collections;
import java.util.HashMap;

import java.util.Scanner;

public class Test {



    public static void main(String[] args) {
        HashMap test = new HashMap();
        String a = new String("123");

        String b = "123";
        String c = "123";
        System.out.println(a == b );
        System.out.println(b == c);
        a = a.intern();
        System.out.println(a == b);


    }

}
