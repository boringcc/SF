package Linklist;

import java.util.HashMap;

public class copyListWithRand1_57 {

    public static Node copyListWithRand(Node head) {

        HashMap<Node, Node> map = new HashMap<Node, Node>();

        Node cur = head;

        while (cur != null){
            map.put(cur,new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static Node copyListWithRand2(Node head) {
        if (head == null){
            return null;
        }
        Node cur = head;
        Node next = null;
        //复制节点 1->2->3  = 1->1'->2->2'->3->3'
        while (cur != null){
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node curCopy = null;
        //设置复制节点的rand
        while (cur != null){
            next = cur.next.next;
            curCopy = cur .next;
            curCopy.rand = cur.rand == null ? null : cur.rand.next;
            cur = next;
        }
        Node res = head.next;
        cur = head;
        //拆分1->1'->2->2'->3->3' = 1'->2'->3'
        while (cur != null){
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ?  next.next : null;
            cur = next;
        }
        return res;
    }


}
