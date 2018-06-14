package test;

import SFShiYang.TSP;

import java.util.Collections;
import java.util.HashMap;

import java.util.Scanner;

public class Test {



    public static void main(String[] args) {
        HashMap test = new HashMap();
        String a = "123";
        String b = "123";
        people p1 = new people(1,"cc");
        people p2 = new people(1,"cc");
        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(a.equals(b));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }

}
