package string;

public class FindFirstNotRepeatingChar {

    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar("asbbat"));
    }

    public static int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0 ) return -1;
        StringBuffer sb = new StringBuffer(str);
        for (int i = 0;i < sb.length();i++){
            char c = str.charAt(i);
            sb.setCharAt(i,'0');
            if(sb.indexOf(c + "") == -1)
                return i;
            sb.setCharAt(i,c);
        }
        return -1;
    }

}
