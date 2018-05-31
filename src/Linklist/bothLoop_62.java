package Linklist;

public class bothLoop_62 {

    //总程序
    public static Node getIntersectNode(Node head1,Node head2){
        if(head1 == null || head2 == null){
            return  null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if(loop1 == null && loop2 == null){
            return noLoop(head1,head2);
        }

        if(loop1!=null && loop2!=null){
            return bothLoop(head1,loop1,head2,loop2);
        }
        return null;

    }


    //情况一：是否有环，有则返回第一个进入环的节点
    public static Node getLoopNode(Node head){
        if (head == null || head.next == null || head.next.next == null){
            return null;
        }
        Node n1 = head.next;
        Node n2 = head.next.next;
        while (n1 != n2){
            if(n2.next == null || n2.next.next == null){
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head;
        while (n1 != n2){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    //问题2：如何判断两个环相交，相交则返回第一个入环节点，没有则返回null
    public static Node noLoop(Node head1,Node head2){
        if(head1 == null || head2 == null){
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0; //记下相差的长度
        while (cur1 != null){
            n++;
            cur1 = cur1.next;
        }
        while (cur2 != null){
            n--;
            cur2 = cur2.next;
        }
        if(cur1 != cur2){
            return null;
        }
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 :head1;
        n = Math.abs(n);
        while (n != 0){
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    //问题3：如何判断两个有环是否相交，相交则返回第一个相交的节点，不相交则返回null
    public static Node bothLoop(Node head1,Node loop1,Node head2,Node loop2){
        Node cur1 = null;
        Node cur2 = null;
        if(loop1 == loop2){
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != null){
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != null){
                n--;
                cur2 = cur2.next;
            }
            cur1 = n >0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 :head1;
            n = Math.abs(n);
            while (n != 0){
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else {
            cur1 = loop1.next;
            while (cur1 != loop1){
                if(cur1  == loop2){
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

}
