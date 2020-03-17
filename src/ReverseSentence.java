import java.util.Arrays;

public class ReverseSentence {

    public static void main(String[] args) {
        String str = "aa";
        System.out.println(Arrays.toString(str.split("a")));

    }

    public static String ReverseSentence(String str) {
        if (str.trim().equals("")) return str;
        StringBuffer sb = new StringBuffer();
        String[] s = str.split(" ");
        for (int i = s.length - 1;i >= 0;i--){
            sb.append(s[i]);
            if (i != 0) sb.append(" ");
        }
        return sb.toString();
    }

}
