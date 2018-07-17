package leetCode;

//数组加一，得到新的数组
public class esay_66 {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i = digits.length-1; i >= 0; i--){
            if(carry == 0){
                return digits;
            }
            int tmp = digits[i] + carry;
            carry = tmp / 10;
            digits[i] = tmp%10;
        }

        if(carry != 0){
            int[] result = new int[digits.length+1];
            result[0] = 1;
            return result;
        }
        return digits;
    }
}
