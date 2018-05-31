package SFShiYang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TSP {

    public static class Bttsp {
        public int n;//图G的顶点数
        public int[] x;//当前解
        public int[] bestx;//当前最优解
        public float bestc;//当前最优值
        public float cc;//当前费用
        public float[][] a;//图G的邻接矩阵
        public Bttsp(float[][] aa,int nn){
            n=nn;
            x=new int[n+1];
            for(int i=1;i<=n;i++){
                x[i]=i;
            }
            bestc=10000;
            bestx=new int[n+1];
            cc=0;
            a=aa;

        }

        public Bttsp(float[][] a){
            this.a=a;
        }

        public static class HeapNode implements Comparable{
            float lcost;//子树费用的下界
            float cc;//当前费用
            float rcost;//x[s:n-1]中顶点最小出边费用和
            int s;//根节点到当前节点的路径为x[0:s]
            int[] x;//需要进一步搜索的顶点是x[s+1:n-1]

            //构造方法
            public HeapNode(float lc,float ccc,float rc,int ss,int[] xx){
                lcost=lc;
                cc=ccc;
                s=ss;
                x=xx;
            }
            @Override
            public int compareTo(Object x){
                float xlc=((HeapNode) x).lcost;
                if(lcost<xlc) {return -1;}
                if(lcost==xlc) {return 0;}
                return 1;
            }
        }

        public void swap(int[] x,int i,int j){//交换函数
            int temp=x[i];
            x[i]=x[j];
            x[j]=temp;
        }

        public void backtrack(int i){
            if(i==n){
                if(a[x[n-1]][x[n]]!=-1&&a[x[n]][1]!=-1&&(bestc==10000)||cc+a[x[n-1]][x[n]]+a[x[n]][1]<bestc){
                    for(int j=1;j<=n;j++){
                        bestx[j]=x[j];

                    }
                    bestc=cc+a[x[n-1]][x[n]]+a[x[n]][1];
                }
            }else{
                for(int j=i;j<=n;j++){
                    if(a[x[i-1]][x[j]]!=-1&&(bestc==10000||cc+a[x[i-1]][x[j]]<bestc)){
                        swap(x,i,j);
                        cc+=a[x[i-1]][x[i]];
                        backtrack(i+1);
                        cc-=a[x[i-1]][x[i]];
                        swap(x,i,j);
                    }
                }
            }
        }


        public float bbTsp(int[] v){
            int n=v.length-1;//节点数
            LinkedList<HeapNode> heap=new LinkedList<HeapNode>();
            //minOut[i]=i的最小出边费用
            float[] minOut=new float[n+1];
            float minSum=0;//最小出边费用和
            for(int i=1;i<=n;i++){//针对每个节点，找到最小出边
                //计算minOut[i]和minSum
                float min=Float.MAX_VALUE;
                for(int j=1;j<=n;j++){
                    if(a[i][j]<Float.MAX_VALUE&&a[i][j]<min) {
                        min = -1;
                    }
                }
                if(min==Float.MAX_VALUE) {
                    return Float.MAX_VALUE;
                }
                minOut[i]=min;
                minSum+=min;
            }

            //初始化
            int[] result = new int[n];
            int[] x=new int[n];
            for(int i=0;i<n;i++) {
                x[i] = i + 1;
            }
            HeapNode enode=new HeapNode(0,0,minSum,0,x);
            float bestc=Float.MAX_VALUE;

            //搜索排列空间树
            while(enode!=null&&enode.s<n-1){
                //非叶节点
                x=enode.x;
                if(enode.s==n-2){
                    //当前扩展结点是叶节点的父节点
                    //再加两条边构成回路
                    //所构成回路是否优于当前最优解
                    if(a[x[n-2]][x[n-1]]!=-1&&a[x[n-1]][1]!=-1&&enode.cc+a[x[n-2]][x[n-1]]+a[x[n-1]][1]<bestc){
                        //找到费用更小的回路
                        bestc=enode.cc+a[x[n-2]][x[n-1]]+a[x[n-1]][1];
                        enode.cc=bestc;
                        enode.lcost=bestc;
                        enode.s++;
                        heap.add(enode);
                        Collections.sort(heap);
                        result = x;
                    }
                }else{//内部结点
                    //产生当前扩展结点的儿子结点
                    for(int i=enode.s+1;i<n;i++){
                        if(a[x[enode.s]][x[i]]!=-1){
                            //可行儿子结点
                            float cc=enode.cc+a[x[enode.s]][x[i]];
                            float rcost=enode.rcost=minOut[x[enode.s]];
                            float b=cc+rcost;//下界
                            if(b<bestc){
                                //子树可能含有最优解，结点插入最小堆
                                int[] xx=new int[n];
                                for(int j=0;j<n;j++) {
                                    xx[j] = x[j];
                                }
                                xx[enode.s+1]=x[i];
                                xx[i]=x[enode.s+1];
                                HeapNode node=new HeapNode(b,cc,rcost,enode.s+1,xx);
                                heap.add(node);
                                Collections.sort(heap);
                            }
                        }
                    }

                }

                //取下一个扩展结点
                enode=heap.poll();
            }
            //将最优解复制到v[1...n]
            for(int i=0;i<n;i++) {
                v[i + 1] = result[i];
            }
            return bestc;
        }

        public static void main(String[] args) throws IOException {


            List<String> testList = new ArrayList<String>();
            File file = new File("E:\\test\\TSP.txt");
            String test = null;
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((test = br.readLine()) != null) {
                testList.add(test);
            }
            for (int j1 = 0; j1 < testList.size(); j1++) {
                String[] anli = testList.get(j1).split(" ");


                int n = Integer.parseInt(anli[0]);
                float[][] a = new float[n+1][n+1];//a下标从1开始，0用来凑数；-1表示不通，1表示连通
                for(int x1 = 0;x1 <= n;x1++){
                    String hang = anli[x1+1];
                    String[] value = hang.split(",");
                    for(int y1 = 0;y1 <= n;y1++){
                        if (x1 == y1&&x1!=0&&y1!=0){
                            a[x1][y1] = -1;
                        }else {
                            a[x1][y1] = Integer.parseInt(value[y1]);
                        }
                    }
                }


                //回溯法
                Bttsp b = new Bttsp(a, n);
                b.backtrack(2);
                System.out.println("回溯法最短回路长为：" + b.bestc);
                System.out.print("回溯法最短回路为：");
                for (int i = 1; i <= n; i++) {
                    System.out.print(b.bestx[i] + " ");
                }


                //分支界限法
                int x = n;
                System.out.println();
                Bttsp b2 = new Bttsp(a);
                int[] v = new int[x + 1];
                System.out.println("分支界限法最短回路长为：" + b2.bbTsp(v));
                System.out.print("分支界限法最短回路为：");
                for (int i = 1; i <= x; i++) {
                    System.out.print(v[i] + " ");
                }
                System.out.println();
                System.out.println();
            }
        }
    }
}
