package array;

import org.junit.Test;

import java.util.ArrayList;

public class PrintArrayClockwise {

    @Test
    public void  test(){
        int [][] a = {{1,2},{3,4}};
        System.out.println(printMatrix(a));
    }

    /**
     * 解题思路：
     * 顺时针打印就是按圈数循环打印，一圈包含两行或者两列
     * 在打印的时候会出现某一圈中只包含一行，要判断从左向右打印和从右向左打印的时候是否会出现重复打印，
     * 同样只包含一列时，要判断从上向下打印和从下向上打印的时候是否会出现重复打印的情况
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix[0] == null)
            return res;
        int row = matrix.length;
        int col = matrix[0].length;
        int circle = ((col > row ? row : col) + 1) / 2;
        for (int i  = 0;i < circle;i++){
            for (int j = i;j <= col - 1 - i;j++){   //从左到右
                res.add(matrix[i][j]);
            }
            for (int j = i + 1;j <= row - i - 2;j++){   //从上到下
                res.add(matrix[j][col - 1 - i]);
            }
            for (int j = col - 1 - i;(j >= i) && (row - i - 1 != i);j--){   //从右到左（判断是否重复打印）
                res.add(matrix[row - i - 1][j]);
            }
            for (int j = row - i - 2;(j >= i + 1) && (col - 1 - i != i);j--){   //从下到上（判断是否重复）
                res.add(matrix[j][i]);
            }
        }
        return res;
    }
}
