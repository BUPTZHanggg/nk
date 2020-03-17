import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CheckStringIsNumeric {


    @Test
    public void test(){
        String str = "1E+4.3";
        System.out.println(isNumeric(str.toCharArray()));
        System.out.println((char)97);
    }
    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) return false;
        List<Character> list = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        if (str.length == 1) return list.contains(str[0]);
        String string = new String(str);
        int countE = 0;
        int countPoint = 0;
        int countSymbol = 0;
        for (int i = 0;i < str.length;i++) {
            if (str[i] == 'e' || str[i] == 'E') countE++;
            if (str[i] == '.') countPoint++;
            if (str[i] == '-' || str[i] == '+') countSymbol++;
        }
        if (countE > 1){
            return false;
        }else if(countE == 1){
            int index = string.indexOf('e') != -1 ? string.indexOf('e') : string.indexOf('E');
            if (index == 0 || index == string.length() - 1) return false;
            String str1 = string.substring(index + 1, string.length());
            String str2 = string.substring(0, index);
            return checkAfter(str1) && checkBefore(str2);
        }else {
            return checkWithoutE(string, countPoint, countSymbol);
        }
    }

    public boolean checkWithoutE(String string, int countPoint, int countSymbol){
        if (countPoint > 1 || countSymbol > 1) return false;
        if (string.indexOf('.') == string.length() - 1) return false;
        if ((string.charAt(0) == '+' || string.charAt(0) == '-') && string.charAt(1) =='.') return false;
        List<Character> list = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        for (int i = 0;i < string.length();i++){
            if (i == 0){
                if (!(list.contains(string.charAt(i)) || string.charAt(i) == '+'
                        || string.charAt(i) == '-')) return false;
            }else {
                if (!(list.contains(string.charAt(i)) || string.charAt(i) == '.')) return false;
            }
        }
        return true;
    }

    public boolean checkAfter(String string){
        List<Character> list = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        if (string.length() == 1) return list.contains(string.charAt(0));
        if (!(string.charAt(0) == '+' || string.charAt(0) == '-' || list.contains(string.charAt(0)))) return false;
        for (int i = 1;i < string.length();i++){
            if (!(list.contains(string.charAt(i))))
                return false;
        }
        return true;
    }

    public boolean checkBefore(String string){
        if (string.charAt(string.length() - 1) == '.') return false;
        List<Character> list = Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9');
        if (string.length() == 1) return list.contains(string.charAt(0));
        if (string.charAt(0) == '-' || string.charAt(0) == '+'){
            if (string.length() == 2) return list.contains(string.charAt(1));
            if (string.charAt(2) != '.' || !(list.contains(string.charAt(1)))) return false;
            for (int i = 3;i < string.length();i++){
                if (!(list.contains(string.charAt(i)))) return false;
            }
            return true;
        }else {
            if (string.charAt(1) != '.' || !(list.contains(string.charAt(0)))) return false;
            for (int i = 2;i < string.length();i++){
                if (!(list.contains(string.charAt(i)))) return false;
            }
            return true;
        }

    }

}
