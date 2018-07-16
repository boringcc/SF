package leetCode;

public class easy_66 {
    public static int[] plusOne(int[] digits) {
        char[] s = new char[digits.length];
        for(int i = 0;i < digits.length;i++){
            s[i] = (char)digits[i];
        }
        String ss = String.valueOf(s);


        return null;
    }

    public static void main(String[] args) {
        int[] a = {4,3,2,1};
        plusOne(a);

    }
}
