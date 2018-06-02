package Linklist;

import java.util.LinkedList;
import java.util.Queue;

public class Convert_74 {

    public static Node convert(Node head){
        Queue<Node> queue = new LinkedList<Node>();
        inorderToQueue(head,queue);
        if(queue.isEmpty()){
            return head;
        }
        head = queue.poll();
        Node pre = head;
        pre.left = null;
        Node cur = null;
        while (!queue.isEmpty()){
            cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = null;
        return head;
    }

    //将二叉树的节点按照中序排序插入队列中
    public static void inorderToQueue(Node head, Queue<Node> queue){
        if(head == null){
            return;
        }
        inorderToQueue(head.left,queue);
        queue.offer(head);
        inorderToQueue(head.right,queue);
    }


    public static Node convert2(Node head){
        if(head != null){
            return null;
        }
        Node last = process(head);
        head = last.right;
        return head;

    }

    public static Node process(Node head){
        if(head == null){
            return null;
        }
        Node leftE = process(head.left);
        Node rightE = process(head.right);
        Node leftS = leftE != null ? leftE.right : null;
        Node rightS = rightE != null ? rightE.right : null;
        if(leftE != null && rightE != null){
            leftE.right = head;
            head.left = leftE;
            head.right = rightE;
            rightS.left = head;
            rightS.right = leftS;
            return rightE;
        }else if(leftE != null){
            leftE.right = head;
            head.left = leftE;
            head.right = leftS;
            return head;
        }else if(rightE != null){
            head.right = rightS;
            rightS.left = head;
            rightE.right = head;
            return rightE;
        }else {
            head.right = head;
            return head;
        }

    }

}
