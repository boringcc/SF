package leetCode;

public class easy_101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return symmetric(root.left,root.right);
    }

    public boolean symmetric(TreeNode left,TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        return (left.val == right.val )&&symmetric(left.left,right.right)&&symmetric(left.right,right.left);
    }
}
