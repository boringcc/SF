package SFShiYang;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.*;
import java.util.*;

public class oneZeroBag {
    public static void main(String[] args) throws IOException {

        List<String> testList = new ArrayList<String>();
        File file = new File("E:\\test\\oneZeroBag.txt");
        String test = null;
        BufferedReader br = new BufferedReader(new FileReader(file));
        while ((test = br.readLine())!=null){
            testList.add(test);
        }
        for(int j1 = 0;j1<testList.size();j1++) {
            String anli = testList.get(j1);
            String[] anli1 = anli.split(" ");
            String[] anliW = anli1[2].split(",");
            String[] anliP = anli1[3].split(",");
            int m = Integer.parseInt(anli1[0]);
            int n = Integer.parseInt(anli1[1]);
            int w[] = new int[n];
            int p[] = new int[n];

            //赋值
            for(int t = 0;t<n;t++){
                w[t] = Integer.parseInt(anliW[t]);
                p[t] = Integer.parseInt(anliP[t]);
            }

            int[] road = new int[n];
            TX(m, n, w, p);

            int c[][] = BackPack_Solution(m, n, w, p);
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    System.out.print(c[i][j] + "\t");
                    if (j == m) {
                        System.out.println();
                    }
                }
            }
            System.out.println();
            System.out.println("回溯法求得的最大价值为: " + c[n][m]);
            int i = n;
            int m1 = m;
            while (i > 0) {
                if (c[i][m1] == c[i - 1][m1]) {
                    i--;
                } else {
                    m1 = m1 - w[i - 1];
                    road[i - 1] = 1;

                }
            }
            for (int y = 0; y < n; y++) {
                if (road[y] == 1) {
                    System.out.println("物品" + (y + 1) + "放入");
                }
            }
        }

    }

    public static int TX(int m, int n,int [] w,int[] p){
        ArrayList<Integer> valueList = new ArrayList<Integer>();
        Map<String,Integer> map  = new HashMap<String, Integer>();
        for(int i = 0; i < n;i++){
            map.put(Integer.toString(i+1),p[i]);
        }
        map = sortMap((HashMap<String, Integer>) map);
        int result = 0;
        Set<String> keySet = map.keySet();
        Iterator<String> iter = keySet.iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            Integer i = Integer.parseInt(key);
            if (m-w[i-1] < 0) {
                continue;
            }else {
                m-=w[i-1];
                result+=map.get(key);
                System.out.println("第" + i + "个物品的重量" + w[i-1]);
                System.out.println("第" + i + "个物品放入");
            }
        }
        System.out.println("最大价值为:" + result);
        return result;
    }

    /**
     * @param m 表示背包的最大容量
     * @param n 表示商品个数
     * @param w 表示商品重量数组
     * @param p 表示商品价值数组
     */
    public static int[][] BackPack_Solution(int m, int n, int[] w, int[] p) {
        //c[i][v]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值
        //(第一行和第一列为序号，其数值为0)
        int c[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            c[i][0] = 0;
        }
        for (int j = 0; j < m + 1; j++) {
            c[0][j] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                //当物品为i件重量为j时，如果第i件的重量(w[i-1])小于重量j时，c[i][j]为下列两种情况之一：
                //(1)物品i不放入背包中，所以c[i][j]为c[i-1][j]的值
                //(2)物品i放入背包中，则背包剩余重量为j-w[i-1],所以c[i][j]为c[i-1][j-w[i-1]]的值加上当前物品i的价值
                if (w[i - 1] <= j) {
                    //新的价值c[i - 1][j - w[i - 1]] + p[i - 1]

                    if (c[i - 1][j] < (c[i - 1][j - w[i - 1]] + p[i - 1])) {
                        c[i][j] = c[i - 1][j - w[i - 1]] + p[i - 1];
                    } else {
                        c[i][j] = c[i - 1][j];
                    }
                } else {
                    c[i][j] = c[i - 1][j];
                }

            }
        }
        return c;
    }



    private static HashMap<String, Integer> sortMap(HashMap<String, Integer> oldhMap) {

        /*
         *   在 Collections 有个排序的方法  sort(List<T> list, Comparator<? super T> comparator)
         *   第一个参数为List map无法使用 所以要想办法把map转化为List
         */

        //把map转成Set集合
        Set<Map.Entry<String, Integer>> set = oldhMap.entrySet();

        //通过set 创建一个 ArrayList 集合
        ArrayList<Map.Entry<String, Integer>> arrayList = new ArrayList<>(set);

        //对arraylist进行倒序排序
        Collections.sort(arrayList, new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Map.Entry<String, Integer> arg0,
                               Map.Entry<String, Integer> arg1) {
                //逆序 就用后面的参数 - 前面的参数
                return arg1.getValue() - arg0.getValue();
            }
        });
        //创建一个map
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < arrayList.size(); i++) {
            Map.Entry<String, Integer> entry = arrayList.get(i);
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }

}
