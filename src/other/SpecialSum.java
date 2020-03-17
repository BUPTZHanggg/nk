package other;

import org.junit.Test;

//求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
public class SpecialSum {

    @Test
    public void test(){
        System.out.println(Sum_Solution1(10));
    }

    /**
     * 短路算法
     * @param n
     * @return
     */
    public static int Sum_Solution1(int n) {
        int ans = n;
        boolean b = (ans > 0) && (ans = ans + Sum_Solution(n-1)) > 0;
        return ans;
    }

    /**
     * 用异常结束递归
     * @param n
     * @return
     */
    public static int Sum_Solution(int n) {
        try {
            int i = 1 % n;
            return  n + Sum_Solution(n - 1);
        }catch (Exception e){
            return 0;
        }
    }

}
