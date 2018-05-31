package Linklist;

public class RemoveMidNode_39 {
    public class Node{
        public int value;
        public Node next;
        public Node (int data){
            this.value = data;
        }
    }

    public Node removeMidNode(Node head){
        if (head == null || head.next == null){
            return head;
        }
        Node pre = head;
        Node cur = head.next;
        while (pre.next != null && cur.next.next != null){
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;

    }

}
