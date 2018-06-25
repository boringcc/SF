package leetCode;

public class easy_7 {

    /**
     * 给定一个 32 位有符号整数，将整数中的数字进行反转。
     * 输入: 123
     * 输出: 321
     *
     * 输入: -123
     * 输出: -321
     * @param x
     * @return
     */

    public int reverse(int x) {
        int flag = 0;
        if(x < 0){
            x = -x;
            flag=1;

        }
        String y = Integer.toString(x);
        char[] y1  = y.toCharArray();
        char temp = 0;
        for(int i = 0;i<y1.length/2;i++){
            temp = y1[i];
            y1[i] = y1[y1.length-i-1];
            y1[y1.length-i-1] = temp;
        }
        y= String.valueOf(y1);
        try {
            x = Integer.parseInt(y);
        }catch (Exception e){
            return 0;
        }
        if(flag==1){
            x= -x;
        }
        return x;
    }
}
