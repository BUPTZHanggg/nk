package string;

import org.junit.Test;

public class ReplaceSpaceInString {

    @Test
    public void test(){
        System.out.println(replaceSpace(new StringBuffer("we are young")));

    }

    //--------------------------------------------------------------------------

    /**
     * 问题1：替换字符串，是在原来的字符串上做替换，还是新开辟一个字符串做替换!
     *      当然是在原有的字符串上操作更好
     * 问题2：在当前字符串替换，怎么替换才更有效率（不考虑java里现有的replace方法）。
     *       从前往后替换，后面的字符要不断往后移动，要多次移动，所以效率低下
     *       从后往前，先计算需要多少空间，然后从后往前移动，则每个字符只为移动一次，这样效率更高一点。
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        if (str == null || str.length() == 0)
            return "";
        int spaceNum = 0;//计算空格数
        int len = str.length();
        for (int i = 0;i < len;i++){
            if (str.charAt(i) == ' '){
                spaceNum++;
            }
        }
        int newLen = len + spaceNum * 2;//计算增加长度后的长度
        str.setLength(newLen);
        //两个index分别代表替换前的和替换后的index
        int oldIndex = len - 1;
        int newIndex = newLen - 1;
        for (;oldIndex >=0 && newIndex > oldIndex;oldIndex--){//如果newIndex == oldIndex则表示已经成功，即当前index之前已经没有空格
            if (str.charAt(oldIndex) == ' '){
                str.setCharAt(newIndex--, '0');
                str.setCharAt(newIndex--, '2');
                str.setCharAt(newIndex--, '%');
            }else {
                str.setCharAt(newIndex--, str.charAt(oldIndex));
            }
        }
        return str.toString();
    }

    //--------------------------------------------------------------------------
}
