package Stake_Quene;

import com.sun.org.apache.regexp.internal.RE;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaxTree {
    //树结构
    public class  Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }


    public Node getMaxTree(int[] arr){
        Node[] nArr = new Node[arr.length];
        //将每个节点赋值
        for(int i = 0;i < arr.length;i++){
            nArr[i] = new Node(arr[i]);
        }
        Stack<Node> stack = new Stack<Node>();
        HashMap<Node,Node> lBigMap = new HashMap<Node,Node>();
        HashMap<Node,Node> RBigMap = new HashMap<Node,Node>();
        //填充左边第一个大的map
        for(int i = 0;i <nArr.length;i++){
            Node curNode =nArr[i];
            while ((!stack.isEmpty())&& stack.peek().value < curNode.value){
                popStackSetMap(stack,lBigMap);
            }
            stack.push(curNode);
        }
        //处理剩余在栈中的元素
        while (!stack.isEmpty()){
            popStackSetMap(stack,lBigMap);
        }
        //处理右边的时只要将数组倒过来放就可以
        for(int i = nArr.length-1;i >=0 ;i--){
            Node curNode =nArr[i];
            while ((!stack.isEmpty())&& stack.peek().value < curNode.value){
                popStackSetMap(stack,RBigMap);
            }
            stack.push(curNode);
        }
        //处理剩余在栈中的元素
        while (!stack.isEmpty()){
            popStackSetMap(stack,RBigMap);
        }


        //定义头结点
        Node head = null;
        //将每个节点关联起来
        for(int i = 0;i < nArr.length; i++){
            Node curNode = nArr[i];
            Node left = lBigMap.get(curNode);
            Node right = RBigMap.get(curNode);
            if(left == null && right == null){
                //如果没有比它大的则为头结点
                head = curNode;
            }else if(left == null){
                if(right.left == null){
                    right.left = curNode;
                }else {
                    right.right = curNode;
                }
            }else if(right == null){
                if(left.left == null){
                    left.left = curNode;
                }else {
                    left.right = curNode;
                }
            }else {
                //如果左边和右边都有比他大的则选择其中一个比较小的当父结点
                Node parent = left.value < right.value ? left : right;
                if(parent.left == null){
                    parent.right = curNode;
                }else {
                    parent.right = curNode;
                }
            }
        }
        return head;
    }



    public void popStackSetMap(Stack<Node> stack, HashMap<Node,Node> map){
        Node popNode = stack.pop();
        if(stack.isEmpty()){
            map.put(popNode,null);
        }else {
            map.put(popNode,stack.peek());
        }
    }



}
