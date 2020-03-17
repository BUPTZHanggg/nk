package string;

import java.util.ArrayList;
import java.util.Collections;

public class StringPermutation {

    public static void main(String[] args) {
        StringPermutation sp = new StringPermutation();
        System.out.println(sp.Permutation("aAc"));
    }

    //---------------------------------------------------------

    /**
     * 基于回溯的思想
     * 运用递归
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<String>();
        if (str == null || str.length() == 0) return res;
        PermutationHelper(str.toCharArray(), 0, res);
        Collections.sort(res);
        return res;
    }

    private void PermutationHelper(char[] charArray, int i, ArrayList<String> res) {
        if (i == charArray.length - 1){
            String str = String.valueOf(charArray);
            if (!res.contains(str)){
                res.add(str);
            }
        }else {
            for (int j = i;j < charArray.length;j++){
                swap(charArray,i,j);
                PermutationHelper(charArray,i+1,res);
                swap(charArray,i,j);//回溯
            }
        }
    }

    private void swap(char[] charArray, int i, int j) {
        char tmp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = tmp;
    }


    //------------------------------------------------------------------------

}
