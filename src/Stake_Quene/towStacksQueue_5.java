package Stake_Quene;

import java.util.Stack;

public class towStacksQueue_5 {

    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public towStacksQueue_5(){
        this.stackPush = new Stack<Integer>();
        this.stackPop = new Stack<Integer>();
    }

    public void add(int pushInt){
        this.stackPush.push(pushInt);
    }

    public int poll(){
        if(stackPush.empty() && stackPop.empty()){
            throw new RuntimeException("Your Quene is Empty");
        }else if(stackPop.empty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek(){
        if(stackPush.empty() && stackPop.empty()){
            throw new RuntimeException("Your Quene is Empty");
        }else if(stackPop.empty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }





}
