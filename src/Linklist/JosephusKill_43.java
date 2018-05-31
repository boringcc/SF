package Linklist;

public class JosephusKill_43 {

    public class Node{
        public int value;
        public Node next;
        public Node (int data){
            this.value = data;
        }
    }

    public Node josephusKill1(Node head,int m){
        if (head == null || head.next == head || m < 1){
            return  head;
        }
        //先求出最后一个节点last
        Node last = head;
        while (last.next != head){
            last = last.next;
        }
        int count = 0;
        //head != last 表示只剩下一个节点，返回即可
        while (head != last){
            if(++count == m){
                //删除节点
                last.next = head.next;
                count = 0;
            }else {
                last = last.next;
            }
            head = last.next;
        }
        return head;
    }


    public Node josephuKill2(Node head,int m){
        if (head == null || m < 1 || head.next == null){
            return head;
        }
        Node cur = head.next;
        int tmp = 1; //tmp - > list size
        while (cur != head){
            cur = cur.next;
            tmp++;
        }
        tmp = getLive(tmp,m);
        while (--tmp != 0){
            head = head.next;
        }
        //成环
        head.next = head;
        return head;
    }

    public int getLive(int i,int m){
        if(i == 1){
            return 1;
        }
        return (getLive(i-1,m) + m -1)%i +1;
    }

}
