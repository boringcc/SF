package leetCode;

import Linklist.Node;

//树的序列化
public class easy_100 {
    public static boolean isSameTree(TreeNode p, TreeNode q) {

        return serialBypre(p).equals(serialBypre(q));
    }

    public static String serialBypre(TreeNode head){
        if(head == null){
            return "#!";
        }
        String res = head.val+"!";
        res += serialBypre(head.left);
        res += serialBypre(head.right);
        return res;
    }

    public static void main(String[] args) {
        TreeNode yi = new TreeNode(1);
        TreeNode er = new TreeNode(2);
        TreeNode san = new TreeNode(3);
        yi.left = er;
        yi.right = san;
        TreeNode si = new TreeNode(1);
        TreeNode wu = new TreeNode(2);
        TreeNode liu = new TreeNode(3);
        si.left = wu;
        si.right = liu;
        System.out.println(isSameTree(yi,si));
    }
}
