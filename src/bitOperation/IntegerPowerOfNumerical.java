package bitOperation;

public class IntegerPowerOfNumerical {

    /**
     * 1.全面考察指数的正负、底数是否为零等情况。
     * 2.写出指数的二进制表达，例如13表达为二进制1101。
     * 3.举例:10^1101 = 10^0001*10^0100*10^1000。
     * 4.通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。
     */
    public double Power(double base, int exponent) {
        double res = 1.0;
        int exp = exponent;
        if (exponent < 0){
            if (base == 0)
                throw  new RuntimeException("分母不能为0");
            exponent = -exponent;
        }else if(exponent == 0){
            return 1;
        }
        while (exponent != 0){
            if ((exponent & 1) == 1)
                res = res * base;
            base = base * base;
            exponent = exponent >> 1;
        }
        return exp > 0 ? res : (1 / res);
    }
}
