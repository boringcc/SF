package RBTree;

import java.util.TreeMap;

/**
 * 红黑树
 * @param <T>
 */

public class RBTree<T extends Comparable<T>> {
    private RBTNode<T> mRoot;    //根节点


    private static final boolean RED = false;
    private static final boolean BLACK = true;

    /**
     * 红黑树的基本结构
     * @param <T>
     */
    public class RBTNode<T extends Comparable<T>> {
        boolean color;        // 颜色
        T key;                // 关键字(键值)
        RBTNode<T> left;    // 左孩子
        RBTNode<T> right;    // 右孩子
        RBTNode<T> parent;    // 父结点

        public RBTNode(T key, boolean color, RBTNode<T> parent, RBTNode<T> left, RBTNode<T> right) {
            this.key = key;
            this.color = color;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

    }

    /**
     * 红黑树左旋操作
     * @param x
     */
    private void leftRotate(RBTNode<T> x){
        //设置x的右孩子为y
        RBTNode<T> y = x.right;
        // 将 “y的左孩子” 设为 “x的右孩子”；
        x.right = y.left;
        // 如果y的左孩子非空，将 “x” 设为 “y的左孩子的父亲”
        if(y.left != null){
            y.left.parent = x;
        }
        // 将 “x的父亲” 设为 “y的父亲”
        y.parent = x.parent;
        // 如果 “x的父亲” 是空节点，则将y设为根节点
        if(x.parent == null){
            this.mRoot = y;
        }else {
            // 如果 x是它父节点的左孩子，则将y设为“x的父节点的左孩子”,否则设置为右孩子
            if(x == x.parent.left){
                x.parent.left = y;
            }else {
                x.parent.right = y;
            }
        }
        // 将 “x” 设为 “y的左孩子”
        y.left = x;
        // 将 “x的父节点” 设为 “y”
        x.parent = y;
    }

    private void rightRotate(RBTNode<T> y){
        RBTNode<T> x = y.left;
        y.left = x.right;
        if(x.right != null){
            x.right.parent = y;
        }
        x.parent = y.parent;
        if(y.parent == null){
            this.mRoot = x;
        }else {
            if(y == y.parent.right){
                y.parent.right = x;
            }else {
                y.parent.left = x;
            }
        }
        x.right = y;
        y.parent = x;
    }

    /*
 * 将结点插入到红黑树中
 *
 * 参数说明：
 *     node 插入的结点        // 对应《算法导论》中的node
 */
    private void insert(RBTNode<T> node) {
        int cmp;
        RBTNode<T> y = null;
        RBTNode<T> x = this.mRoot;

        // 1. 将红黑树当作一颗二叉查找树，将节点添加到二叉查找树中。
        while (x != null) {
            y = x;
            cmp = node.key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            }
            else{
                x = x.right;
            }
        }

        node.parent = y;
        if (y!=null) {
            cmp = node.key.compareTo(y.key);
            if (cmp < 0){
                y.left = node;
            }
            else{
                y.right = node;
            }
        } else {
            this.mRoot = node;
        }

        // 2. 设置节点的颜色为红色
        node.color = RED;

        // 3. 将它重新修正为一颗二叉查找树
        insertFixUp(node);
    }

    /*
     * 新建结点(key)，并将其插入到红黑树中
     *
     * 参数说明：
     *     key 插入结点的键值
     */
    public void insert(T key) {
        RBTNode<T> node=new RBTNode<T>(key,BLACK,null,null,null);

        // 如果新建结点失败，则返回。
        if (node != null)
            insert(node);
    }
    /*
     * 红黑树插入修正函数
     *
     * 在向红黑树中插入节点之后(失去平衡)，再调用该函数；
     * 目的是将它重新塑造成一颗红黑树。
     *
     * 参数说明：
     *     node 插入的结点        // 对应《算法导论》中的z
     */
    private void insertFixUp(RBTNode<T> node) {
        RBTNode<T> parent, gparent;

        // 若“父节点存在，并且父节点的颜色是红色”
        while (((parent = parentOf(node))!=null) && isRed(parent)) {
            gparent = parentOf(parent);

            //若“父节点”是“祖父节点的左孩子”
            if (parent == gparent.left) {
                // Case 1条件：叔叔节点是红色
                RBTNode<T> uncle = gparent.right;
                if ((uncle!=null) && isRed(uncle)) {
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }

                // Case 2条件：叔叔是黑色，且当前节点是右孩子
                if (parent.right == node) {
                    RBTNode<T> tmp;
                    leftRotate(parent);
                    tmp = parent;
                    parent = node;
                    node = tmp;
                }

                // Case 3条件：叔叔是黑色，且当前节点是左孩子。
                setBlack(parent);
                setRed(gparent);
                rightRotate(gparent);
            } else {    //若“z的父节点”是“z的祖父节点的右孩子”
                // Case 1条件：叔叔节点是红色
                RBTNode<T> uncle = gparent.left;
                if ((uncle!=null) && isRed(uncle)) {
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }

                // Case 2条件：叔叔是黑色，且当前节点是左孩子
                if (parent.left == node) {
                    RBTNode<T> tmp;
                    rightRotate(parent);
                    tmp = parent;
                    parent = node;
                    node = tmp;
                }

                // Case 3条件：叔叔是黑色，且当前节点是右孩子。
                setBlack(parent);
                setRed(gparent);
                leftRotate(gparent);
            }
        }

        // 将根节点设为黑色
        setBlack(this.mRoot);
    }

    private void setRed(RBTNode<T> node){
        node.color = RED;
    }

    private void setBlack(RBTNode<T> node){
        node.color = BLACK;
    }

    private boolean isRed(RBTNode<T> node) {
        return RED == node.color;
    }

    private RBTNode parentOf(RBTNode<T> node) {
        return node.parent;
    }


}
