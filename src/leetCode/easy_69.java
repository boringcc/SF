package leetCode;

//x的平方根，变种二分
public class easy_69 {
    public int mySqrt(int x) {
        int i=0, j=x;
        while (i<=j) {
            int m = (i+j)/2;
            long m2 = (long)m*m;
            if (m2==(long)x) return m;
            if (m2>x) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i-1;
    }
}
