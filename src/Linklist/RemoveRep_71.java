package Linklist;

import java.util.HashSet;

public class RemoveRep_71 {
    /**
     * 方法一：用hashset存取Node的值然后判断后面的是否重复，重复则跳过
     * @param head
     */
    public static void removerRep1(Node head){
        if(head == null){
            return;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        Node pre = head;
        Node cur = head.next;
        set.add(head.value);
        while (cur != null){
            if(set.contains(cur.value)){
                pre.next = cur.next;
            }else {
                pre = cur;
                set.add(cur.value);
            }
            cur = cur.next;
        }
    }

    public static void removeRep2(Node head){
        Node cur = head;
        Node pre = null;
        Node next = null;
        while (cur != null){
            pre = cur;
            next = cur.next;
            while (next!= null){
                if(cur.value == next.value){
                    pre.next = next.next;
                }else {
                    pre = next;
                }
                next = next.next;
            }
            cur = cur.next;
        }

    }

}
