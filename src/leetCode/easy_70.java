package leetCode;

//斐波那契数列
public class easy_70 {


    public static int climbStairs(int n) {
        if (n < 1){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int res = 2;
        int pre = 1;
        int tmp = 0;
        for (int i = 3;i <= n;i++){
            tmp = res;
            res = res + pre;
            pre = tmp;
        }
        return res;
    }
    public int climbStairs2(int n) {
        if(n < 1) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }
        int pre[] = new int [] {1,2};
        int result = pre[0] + pre[1];
        for (int i = 3; i <= n; i++) {
            result = pre[0] + pre[1];
            pre[0] = pre[1];
            pre[1] = result;
        }
        return result;
    }





    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
