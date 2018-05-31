package Stake_Quene;

import java.util.Stack;

public class getMinStack_1 {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public getMinStack_1(){
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    //第一种方案
    public void push(int newNum){
        if(this.stackMin.isEmpty()){
            this.stackMin.push(newNum);
        }else if(newNum <= getMin()) {
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    public int pop(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("Your Stake is Empty");
        }
        int value = this.stackData.pop();
        if(value == getMin()){
            return this.stackMin.pop();
        }
        return value;
    }

    //第二种方案
    public void push2(int newNum){
        if(this.stackMin.isEmpty()){
            this.stackMin.push(newNum);
        }else if(newNum <= getMin()) {
            this.stackMin.push(newNum);
        }else {
            this.stackMin.push(this.getMin());
        }
        this.stackData.push(newNum);
    }

    public int pop2(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("Your Stake is Empty");
        }
        this.stackMin.pop();
        return this.stackData.pop();
    }






    public int getMin(){
        if(this.stackMin.isEmpty()){
            throw new RuntimeException("Your Stake is Empty");
        }else {
            return this.stackMin.peek();
        }
    }


    public static void main(String[] args) {

    }
}
