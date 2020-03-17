package other;

import org.junit.Test;

//写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号
public class SpecialAdd {


    /**
     * 5-101，7-111
     *
     * 第一步：相加各位的值，不算进位，得到010，二进制每位相加就相当于各位做异或操作，101^111。
     *
     * 第二步：计算进位值，得到1010，相当于各位做与操作得到101，再向左移一位得到1010，(101&111)<<1。
     *
     * 第三步重复上述两步， 各位相加 010^1010=1000，进位值为100=(010&1010)<<1。
     *      继续重复上述两步：1000^100 = 1100，进位值为0，跳出循环，1100为最终结果。
     *
     *注：负数也成立
     * @param num1
     * @param num2
     * @return
     */
    public int Add(int num1,int num2) {
        int notStep = num1 ^ num2;
        int step = (num1 & num2) << 1;
        while (step != 0){
            int stepTmp = step;
            step = (notStep & step) << 1;
            notStep = notStep ^ stepTmp;
        }
        return notStep;
    }

}
