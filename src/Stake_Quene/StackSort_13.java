package Stake_Quene;

import java.util.Stack;

public class StackSort_13 {

    private Stack<Integer> stack;

    public StackSort_13(){
        this.stack = new Stack<Integer>();
    }

    public static void sortStackByStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack<Integer>();
        while (!stack.isEmpty()){
            int cur = stack.pop();
            while (!help.isEmpty()&&help.peek() < cur){
                stack.push(help.pop());
            }
        }

        while (!help.isEmpty()){
            stack.push(help.pop());
        }
    }



}
