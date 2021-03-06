package leetCode;
//有序数组中的单一元素
public class mid_540 {
    public static int singleNonDuplicate(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (m % 2 == 1)
                m--;   // 保证 l/h/m 都在偶数位，使得查找区间大小一直都是奇数
            if (nums[m] == nums[m + 1])
                l = m + 2;
            else
                h = m;
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] a = {0,1,1};
        System.out.println(singleNonDuplicate(a));
    }
}
