package bitOperation;

public class StrToInt {

    /**
     *
     * (res << 1) + (res << 3) = res * 2 + res * 8 = res * 10 。
     * 字符'0'到'9'的ascii值的低4个二进制位刚好就是0到9所以str[i]&0xf等于str[i]-'0'
     *
     * @param str
     * @return
     */
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) return 0;
        int res = 0;
        int checkPositive = (str.charAt(0) == '-') ? -1 : 1;
        boolean che = (str.charAt(0) == '-') || (str.charAt(0) == '+');
        for (int i = (che ? 1 : 0);i < str.length();i++){
            if (str.charAt(i) < '0' || str.charAt(i) > '9')
                return 0;
            res = (res << 1) + (res << 3) + (str.charAt(i) & 0xf);
        }
        return res * checkPositive;
    }

}
