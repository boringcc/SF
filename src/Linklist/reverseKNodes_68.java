package Linklist;

import java.util.Map;
import java.util.Stack;

public class reverseKNodes_68 {

    /**
     * 方法一：用栈来实现
     * @param head
     * @param K
     * @return
     */
    public Node reverseKNodes1(Node head,int K){
        if(K < 2){
            return head;
        }
        Stack<Node> stack = new Stack<Node>();
        Node newHead = head;
        Node cur = head;
        Node pre = null;
        Node next = null;
        while (cur!=null){
            next = cur.next;
            stack.push(cur);
            if(stack.size() == K){
                pre = resign1(stack,pre,next);
                newHead = newHead == head ? cur : newHead;
            }
            cur = next;
        }
        return newHead;
    }


    //例子：1->2->3->4   stack {3,2,1} left = null , right = 4  => 3->2->1->4  返回1

    public static  Node resign1(Stack<Node> stack , Node left , Node right){
        Node cur = stack.pop();
        if(left != null){
            left.next = cur;
        }
        Node next = null;
        while (!stack.isEmpty()){
            next = stack.pop();
            cur.next = next;
            cur = next;
        }
        cur.next = right;
        return cur;
    }


    /**
     * 第二种方法：用变量来记录，直接在原链表中直接调整
     * @param head
     * @param K
     * @return
     */

    public static Node reverseKNodes2(Node head,int K){
        if(K < 2){
            return head;
        }
        Node cur = head;
        Node start = null;
        Node pre = null;
        Node next = null;
        int count = 1;
        while (cur != null){
            next = cur.next;
            if(count == K){
                start = pre == null ? head : pre.next;
                head = pre == null ? cur : head;
                resign2(pre,start, cur,next);
                pre = start;
                count = 0;
            }
            count++;
            cur = next;
        }
        return head;
    }


    public static void resign2(Node left,Node start,Node end,Node right){
        Node pre = start;
        Node cur = start.next;
        Node next = null;
        while (cur != null){
            next = cur.next;
            cur.next = pre ;
            pre = cur;
            cur = next;
        }
        if(left != null){
            left.next = end;
        }
        start.next = right;
    }


}
