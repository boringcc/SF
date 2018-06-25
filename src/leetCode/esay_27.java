package leetCode;

/**
 * 移除元素
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,

 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。

 注意这五个元素可为任意顺序。

 你不需要考虑数组中超出新长度后面的元素。
 */
public class esay_27 {
    public int removeElement(int[] nums, int val) {
        int n=nums.length;
        int i=0;
        while(i<n){
            if(nums[i]==val){
                n--;
                nums[i]=nums[n];
            } else{
                i++;
            }
        }
        return n;
    }

    //最快解法
    public int removeElement2(int[] nums, int val) {
        int i = -1,j=0;
        int len = nums.length;
        while(j<len){
            if(nums[j] != val) {
                nums[++i] = nums[j];
            }
            j++;
        }
        return i+1;
    }
}
