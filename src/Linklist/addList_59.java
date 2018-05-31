package Linklist;

import java.util.Stack;

public class addList_59 {

    public static Node addList1(Node head1,Node head2){
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        while (head1 != null){
            s1.push(head1.value);
            head1 = head1.next;
        }
        while (head2 != null){
            s2.push(head2.value);
            head2 = head2.next;
        }
        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        Node node = null;
        Node pre = null;
        while (!s1.isEmpty() || !s2.isEmpty()){
            n1  = s1.isEmpty() ? 0 : s1.pop();
            n2  = s2.isEmpty() ? 0 : s2.pop();
            n = n1 + n2 + ca;
            pre = node;
            node = new Node(n%10);
            node.next = pre;
            ca = n /10;
        }
        if(ca == 1){
            pre = node;
            node = new Node(1);
            node.next = pre;
        }

        return node;
    }

    public static Node addList2(Node head1,Node head2){
        head1 = ReverseList_41.reverseList(head1);
        head2 = ReverseList_41.reverseList(head2);
        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        Node c1 = head1;
        Node c2 = head2;
        Node node = null;
        Node pre = null;
        while (c1 != null || c2!=null){
            n1 = c1 == null ? 0 : c1.value;
            n2 = c2 == null ? 0 : c2.value;
            n = n1 + n2 + ca;
            pre = node;
            node = new Node(n%10);
            node.next = pre;
            ca = n / 10;
            c1 = c1 == null ? null : c1.next;
            c2 = c2 == null ? null : c2.next;
        }
        if(ca == 1){
            pre = node;
            node = new Node(1);
            node.next = pre;
        }
        ReverseList_41.reverseList(head1);
        ReverseList_41.reverseList(head2);
        return node;
    }



}
