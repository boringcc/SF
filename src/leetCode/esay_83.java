package leetCode;

//删除有序列表上的重复元素
public class esay_83 {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode next = null;
        while (cur != null){
            next = cur.next;
            while (next != null){
                if(cur.val == next.val) {
                    next = next.next;
                }else {
                    break;
                }

            }
            cur.next = next;
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode yi = new ListNode(1);
        ListNode er = new ListNode(1);
        ListNode san = new ListNode(2);
        yi.next = er;
        er.next = san;

        deleteDuplicates(yi);

        ListNode test = yi;
        while (test != null){
            System.out.println(test.val);
            test = test.next;
        }
    }

}
