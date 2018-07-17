package BinaryTree;

public class morris_110 {

    //中序遍历
    public static void morrisIn(Node head){
        if (head == null){
            return;
        }
        Node cur1 = head;
        Node cur2 = null;
        while (cur1!=null){
            cur2 = cur1.left;
            if(cur2 != null){
                while (cur2.right != null && cur2.right != cur1){
                    cur2 = cur2.right;
                }
                if(cur2.right == null){
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                }else {
                    cur2.right = null;
                }
            }
            System.out.println(cur1.value + " ");
            cur1 = cur1.right;
        }
        System.out.println();
    }
    //先序遍历
    public static void morrisPre(Node head){
        if(head == null){
            return;
        }
        Node cur1 = head;
        Node cur2 = null;
        while (cur1!=null){
            cur2 = cur1.left;
            if(cur2 != null){
                while (cur2.right != null && cur2.right != cur1){
                    cur2 = cur2.right;
                }
                if(cur2.right == null){
                    cur2.right = cur1;
                    System.out.println(cur1.value + " ");
                    cur1 = cur1.left;
                    continue;
                }else {
                    cur2.right = null;
                }
            }else {
                System.out.println(cur1.value + " ");
            }
            cur1 = cur1.right;
        }
        System.out.println();
    }
    //后序遍历
    public static void morrisPos(Node head){
        if (head == null){
            return;
        }
        Node cur1 = head;
        Node cur2 = null;
        while (cur1!=null){
            cur2 = cur1.left;
            if(cur2 != null){
                while (cur2.right != null && cur2.right != cur1){
                    cur2 = cur2.right;
                }
                if(cur2.right == null){
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                }else {
                    cur2.right = null;
                    printEdge(cur1.left);
                }
            }
            cur1 = cur1.right;
        }
        printEdge(head);
        System.out.println();
    }

    public static void printEdge(Node head){
        Node tail = reverseEdge(head);
        Node cur = tail;
        while (cur != null){
            System.out.println(cur.value + " ");
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    public static Node reverseEdge(Node from){
        Node pre = null;
        Node next = null;
        while (from != null){
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node si = new Node(4);
        Node er = new Node(2);
        Node yi = new Node(1);
        Node san = new Node(3);
        Node wu = new Node(5);
        Node liu = new Node(6);
        Node qi = new Node(7);
        er.right = san;
        er.left = yi;
        si.left = er;
        si.right = liu;
        liu.left = wu;
        liu.right = qi;
//        morrisIn(si);
//        morrisPre(si);
        morrisPos(si);
    }
}
