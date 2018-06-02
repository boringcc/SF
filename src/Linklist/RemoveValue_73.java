package Linklist;

import java.util.Stack;

public class RemoveValue_73 {

    /**
     * 用栈去存储
     * @param head
     * @param num
     * @return
     */
    public static Node removeValue(Node head,int num){
        Stack<Node> stack = new Stack<Node>();
        while (head != null){
            if(head.value != num){
                stack.push(head);
            }
            head = head.next;
        }

        while (!stack.isEmpty()){
            stack.peek().next = head;
            head = stack.pop();
        }
        return head;
    }

    /**
     * 直接删除
     * @param head
     * @param num
     * @return
     */
    public static Node removeValue2(Node head, int num){
        while (head!=null){
            if(head.value != num){
                break;
            }
            head = head.next;
        }
        Node pre = head;
        Node cur = head;
        while (cur != null){
            if(cur.value == num){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }



}
