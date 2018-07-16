package leetCode;

/**
 * 最大字段和
 */
public class esay_53 {
    public  static int maxSubArray(int[] nums) {
        int now = 0;
        int sum = 0;
        int max = nums[0];
        while (now < nums.length){
            if(nums[now]+sum > nums[now]){
                sum = sum + nums[now];
            }else {
                sum = nums[now];
            }
            if(sum > max){
                max = sum;
            }
            now++;
        }
        return max;
    }

    public static int maxSum(int[] a){
        int res = a[0];
        int b = 0;
        for(int i = 0;i < a.length;i++){
            b = Math.max(b+a[i],a[i]);
            if(b > res){
                res = b;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {-1};
        System.out.println(maxSum(a));
    }
}
