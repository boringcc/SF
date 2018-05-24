package Stake_Quene;

import java.util.Stack;

public class MaxSizeOfMatrix {



    public int maxRecFromBottom(int[] height){
        if(height == null || height.length == 0){
            return 0 ;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0;i < height.length; i++){
            while ((!stack.isEmpty()) && height[i] <= height[stack.peek()] ){
                int j = stack.pop();
                int k = stack.isEmpty() ? -1: stack.peek();
                int curArea = (i - k -1)*height[j];
                maxArea = Math.max(maxArea,curArea);
            }
            stack.push(i);
        }
        //处理剩余的,但是i变成了length
        while (!stack.isEmpty()){
            int j = stack.pop();
            int k = stack.isEmpty() ? -1: stack.peek();
            int curArea = (height.length - k -1)*height[j];
            maxArea = Math.max(maxArea,curArea);
        }
        return maxArea;
    }
}
