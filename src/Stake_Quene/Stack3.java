package Stake_Quene;

import java.util.Stack;

/**
 * 题目：用递归函数和栈操作逆序一个栈
 */
public class Stack3 {
    private Stack<Integer> stack;

    public Stack3(){
        this.stack = new Stack<Integer>();
    }

    //将栈底元素移除并返回
    public static int getAndRemoveLastElement(Stack<Integer> stack){
        int result = stack.pop();
        if (stack.isEmpty()){
            return result;
        }else {
             int last = getAndRemoveLastElement(stack);
             stack.push(result);
             return last;
        }

    }
   public static void reverse(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
   }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(getAndRemoveLastElement(stack));
    }





}
