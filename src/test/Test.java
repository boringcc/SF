package test;

import SFShiYang.TSP;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.*;

public class Test {

    public static void main(String[] args) {

        String s = "){";
        char[] s1 = s.toCharArray();
        if (s1.length % 2 != 0) {
            System.out.println(0);;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] == '(' || s1[i] == '[' || s1[i] == '{') {
                stack.push(s1[i]);
            }
            if (s1[i] == ')') {
                if(!stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        stack.pop();
                    }
                }
            }
            if (s1[i] == ']') {
                if(!stack.isEmpty()) {
                    if (stack.peek() == '[') {
                        stack.pop();
                    }
                }
            }
            if (s1[i] == '}') {
                if(!stack.isEmpty()) {
                    if (stack.peek() == '{') {
                        stack.pop();
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println(1);;
        } else {
            System.out.println(0);;
        }
    }
}

