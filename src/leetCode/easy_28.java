package leetCode;

/**
 * KMP算法
 */
public class easy_28 {
    public static int strStr(String haystack, String needle) {
        if(needle == ""){
            return 0;
        }
        if(haystack == null || haystack.length() < needle.length()){
            return -1;
        }
        char[] ss = haystack.toCharArray();
        char[] ms = needle.toCharArray();
        int si = 0;
        int mi = 0;
        int[] next = getNextArray(ms);
        while (si < ss.length && mi < ms.length){
            if(ss[si] == ms[mi]){
                si++;
                mi++;
            }else if(next[mi] == -1){
                si++;
            }else {
                mi = next[mi];
            }
        }
        return mi == ms.length ? si-mi:-1;
    }


    public  static int[] getNextArray(char[] ms){
        if(ms.length == 1){
            return new int[] {-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < ms.length){
            if(ms[pos -1] == ms[cn]){
                next[pos++] = cn;
            }else if(cn > 0){
                cn = next[cn];
            }else {
                next[pos++] = 0;
            }
        }
        return next;
    }
}
