package leetCode;

//整合2个有序列表
public class easy_86 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int index = m+n-1;
        while (i>=0&&j>=0){
            if(nums1[i] > nums2[j]){
                nums1[index] = nums1[i];
                index--;
                i--;
            }else {
                nums1[index] = nums2[j];
                index--;
                j--;
            }
        }
        while (i>=0){
            nums1[index] = nums1[i];
            index--;
            i--;
        }
        while (j>=0){
            nums1[index] = nums2[j];
            index--;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,0,0,0};
        int[] b = {2,5,6};
        merge(a,3,b,3);

    }
}
