package leetCode;

/**
 * 最后一个单词的位置
 */
public class easy_58 {
    public static int lengthOfLastWord(String s) {
        s = s.trim();
        int a = s.lastIndexOf(" ");
        return s.length()-1 - a;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
    }
}
