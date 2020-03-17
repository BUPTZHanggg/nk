import org.junit.Test;

public class FirstAppearingOnce {

    @Test
    public void test(){
        char[] chars = "google".toCharArray();
        for (char c:chars
             ) {
            Insert(c);
        }
        System.out.println(FirstAppearingOnce());
    }

    //如果只考虑呢ASCII的128个字符，可以申请一个128大小的数组来实现一个简易的哈希表
    private int[] hashtable = new int[128];
    private StringBuffer sb = new StringBuffer();

    public void Insert1(char ch)
    {
        sb.append(ch);
        hashtable[ch] = hashtable[ch] + 1;
    }

    public char FirstAppearingOnce1()
    {
        for (int i = 0;i < sb.length();i++){
            if (hashtable[sb.charAt(i)] == 1){
                return sb.charAt(i);
            }
        }
        return '#';
    }


    private int[][] array = new int[128][2];
    public void Insert(char ch)
    {
        sb.append(ch);
        hashtable[ch] = hashtable[ch] + 1;
    }

    public char FirstAppearingOnce()
    {
        for (int i = 0;i < sb.length();i++){
            if (hashtable[sb.charAt(i)] == 1){
                return sb.charAt(i);
            }
        }
        return '#';
    }
}
