package Linklist;

public class SelectionSort_80 {



    public static Node selectionSort(Node head){
        Node tail = null;
        Node cur = head;
        Node smallPre = null;
        Node small = null;
        while (cur != null){
            small = cur;
            smallPre = getSmallestPreNode(cur);
            if(smallPre != null){
                small = smallPre.next;
                smallPre.next = small.next;
            }
            cur =  cur == small ? cur.next : cur;
            if(tail == null){
                head = small;
            }else {
                tail.next = small;
            }
            tail = small;
        }
        return head;
    }



    /**
     * 传入一个节点得到该链表的最小值的前一个节点，用来删除
     * @param head
     * @return
     */
    public static Node getSmallestPreNode(Node head){
        Node smallPre = null;
        Node small = head;
        Node pre = head;
        Node cur = head.next;
        while (cur != null){
            if(cur.value < small.value){
                small = cur;
                smallPre = pre;
            }
            pre = cur;
            cur = cur.next;
        }
        return smallPre;
    }
}
