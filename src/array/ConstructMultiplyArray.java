package array;

import org.junit.Test;

import java.util.Arrays;

//给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
//不能使用除法。
public class ConstructMultiplyArray {

    @Test
    public void test(){
        int[] a = {1,2};
        System.out.println(Arrays.toString(multiply(a)));
    }

    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        B[0] = 1;
        for (int i = 1;i < A.length;i++){
            B[i] = B[i - 1] * A[i - 1];
        }
        int tmp = 1;
        for (int i = A.length - 2;i >= 0;i--){
            tmp = tmp * A[i + 1];
            B[i] = B[i] * tmp;
        }
        return B;
    }

}
