package Linklist;

public class InsertNum_82 {

    public static Node insertNum(Node head,int num){
        Node node = new Node(num);
        if(head == null){
            node.next = node;
            return node;
        }
        Node pre = head;
        Node cur = head.next;
        while (cur != head){
            if(pre.value <= node.value && cur.value >= node.value){
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        pre.next = node;
        node.next = cur;
        return head.value < num ? head : node;
    }
}