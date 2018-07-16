package leetCode;

/**
 * 二分查找的变种
 */
public class easy_35 {
    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int hi = nums.length-1;
        int mid = 0;
        while (low <= hi){
            mid = (low +hi)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                hi = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] a =   {1,3,5,6};
        System.out.println(searchInsert(a,7));
    }

}
