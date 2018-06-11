package BinaryTree;

import java.util.Stack;

public class BianLi_88 {

    /**
     * 二叉树的先序遍历递归版
     * @param head
     */
    public static void preOrederRecur(Node head){
        if(head == null){
            return;
        }
        System.out.println(head.value + " ");
        preOrederRecur(head.left);
        preOrederRecur(head.right);
    }

    /**
     * 中序
     * @param head
     */
    public static void inOrederRecur(Node head){
        if(head == null){
            return;
        }
        preOrederRecur(head.left);
        System.out.println(head.value + " ");
        preOrederRecur(head.right);
    }

    /**
     * 后序
     * @param head
     */
    public static void posOrederRecur(Node head){
        if(head == null){
            return;
        }
        preOrederRecur(head.left);
        preOrederRecur(head.right);
        System.out.println(head.value + " ");
    }

    /**
     * 非递归实现先序遍历,借用栈
     * @param head
     */
    public static void preOrederRecur1(Node head){
        Stack<Node> stack = new Stack<Node>();
        stack.add(head);
        while (!stack.isEmpty()){
            head = stack.pop();
            System.out.println(head.value + " ");
            if(head.right != null){
                stack.push(head.right);
            }
            if(head.left != null){
                stack.push(head.left);
            }
        }
    }

    /**
     * 非递归实现中序遍历，借用栈
     * @param head
     */
    public static void inOrederRecur1(Node head){
        if (head == null){
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        while (!stack.isEmpty() || head != null){
            if(head == null){
                head = stack.pop();
                System.out.println(head.value + "");
                head = head.right;
            }else {
                stack.push(head);
                head = head.left;
            }
        }


    }

    /**
     * 非递归实现后序遍历，借用栈
     * @param head
     */
    public static void posOrederRecur1(Node head){
        if (head == null){
            return;
        }
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        s1.push(head);
        while (!s1.isEmpty()){
            head = s1.pop();
            s2.push(head);
            if(head.left != null){
                s1.push(head.left);
            }
            if(head.right != null){
                s1.push(head.right);
            }
        }
        while (!s2.isEmpty()){
            System.out.println(s2.pop().value + " ");
        }
    }

    /**
     * 非递归实现，且只使用一个栈
     * @param h
     */
    public static void posOrederRecur2(Node h){
        if(h == null){
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        stack.push(h);
        Node c = null;
        while (!stack.isEmpty()){
            c = stack.peek();
            if(c.left != null && h != c.left && h != c.right){
                stack.push(c.left);
            }else if(c.right != null && h != c.right){
                stack.push(c.right);
            }else {
                System.out.println(stack.pop() + " ");
                h = c;
            }

        }
    }

}
