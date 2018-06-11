package BinaryTree;

public class PrintEdge_95 {

    public static void printEdge1(Node head){
        if(head == null){
            return;
        }
        int height = getHight(head,0);
        Node[][] edgeMap = new Node[height][2];
        setEdgeMap(head,0,edgeMap);
        for(int i = 0; i != edgeMap.length; i++){
            System.out.print(edgeMap[i][0].value + " " );
        }
        printLeafNotInMap(head,0,edgeMap);
        for(int i = edgeMap.length -1 ; i != -1;i-- ){
            System.out.print(edgeMap[i][1].value + " ");
        }
    }

    public static int getHight(Node h,int l){
        if(h == null){
            return l;
        }
        return Math.max(getHight(h.left,l+1),getHight(h.right,l+1));
    }

    public static void setEdgeMap(Node h,int l,Node[][] edgeMap){
        if(h == null){
            return;
        }
        edgeMap[l][0] = edgeMap[l][0] == null ? h : edgeMap[l][0];
        edgeMap[l][1] = h;
        setEdgeMap(h.left,l+1,edgeMap);
        setEdgeMap(h.right,l+1,edgeMap);
    }

    public static void printLeafNotInMap(Node h,int l, Node[][] m){
        if(h == null){
            return;
        }
        if(h.left == null && h.right == null && h != m[l][0] && h != m[l][1]){
            System.out.println(h.value + " " );
        }
        printLeafNotInMap(h.left,l+1,m);
        printLeafNotInMap(h.right,l+1,m);
    }

    //******************************************************************

    public static void printEdge2(Node head){
        if(head == null){
            return;
        }
        System.out.println(head.value + " ");
        if(head.left != null && head.right != null){
            printLeftEdge(head,true);
            printRightEdge(head,true);
        }else {
            printEdge2(head.left == null ? head.right : head.left);
        }

    }

    public static void printLeftEdge(Node h,boolean print){
        if(h == null){
            return;
        }
        if(print || (h.left == null && h.right == null)){
            System.out.println(h.value + " ");
        }
        printLeftEdge(h.left,print);
        printLeftEdge(h.right,print && h.left == null ? true : false);
    }

    public static void printRightEdge(Node h,boolean print){
        if(h == null){
            return;
        }
        printRightEdge(h.left,print && h.right == null ? true : false);
        printRightEdge(h.right,print);
        if(print || (h.left == null && h.right == null)){
            System.out.println(h.value + " ");
        }

    }






}
