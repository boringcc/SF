package Linklist;

public class LastKthNode_35 {
    //单链表
    public class Node{
        public int value;
        public Node next;
        public Node (int data){
            this.value = data;
        }
    }

    public Node removeLastKthNode(Node head,int lastKth){
        if(head == null && lastKth < 1){
            return head;
        }
        Node cur = head;
        while (cur != null){
            cur= cur.next;
            lastKth--;
        }

        if(lastKth == 0){
            head = head.next;
        }else if(lastKth < 0){
            cur = head;
            while (++lastKth != 0){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }

        return head;

    }

    //双链表
    public class DoubleNode{
        public int value;
        public DoubleNode last;
        public DoubleNode next;
        public DoubleNode(int data){
            this.value = data;
        }
    }
    public DoubleNode removeLastKthNode(DoubleNode head,int lastKth){
        if (head == null && lastKth < 1){
            return head;
        }
        DoubleNode cur = head;
        while (cur != null){
            cur = cur.next;
            lastKth--;
        }
        if(lastKth == 0){
            head = head.next;
            head.last = null;
        }else if (lastKth < 0){
            cur = head;
            while (++lastKth != 0){
                cur = cur.next;
            }
            DoubleNode newNext = cur.next.next;
            cur.next = newNext;
            if(newNext.next != null){
                newNext.last = cur;
            }

        }




        return head;
    }












}
