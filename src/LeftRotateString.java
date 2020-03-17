public class LeftRotateString {

    public static void main(String[] args) {
        System.out.println(LeftRotateString("a", 2));
    }

    public static String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0) return "";
        StringBuffer sb = new StringBuffer();
        int m = n % str.length();
        sb.append(str.substring(m, str.length()));
        sb.append(str.substring(0, m));
        return sb.toString();
    }

}
