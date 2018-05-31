package Linklist;

public class ReversePart_42 {
    public class Node{
        public int value;
        public Node next;
        public Node (int data){
            this.value = data;
        }
    }

    public Node reversePart(Node head, int from,int to){
        int len = 0;
        Node node1 = head;
        Node fPre = null;
        Node tPos = null;
        while (node1 != null){
            len++;
            fPre = len == from - 1 ? node1 : fPre;
            tPos = len == to ? node1 : tPos;
            node1 = node1.next;
        }
        if(from > to || from < 1 || to > len){
            return head;
        }
        node1 = fPre == null ? head : fPre.next;
        Node node2 = node1.next;
        //首先反转最后的
        node1.next = tPos;
        Node next = null;
        while (node2 != tPos){
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }

        if (fPre != null){
            fPre.next = node1;
            return head;
        }
        return node1;
    }

}
