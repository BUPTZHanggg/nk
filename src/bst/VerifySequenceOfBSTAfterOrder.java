package bst;

import org.junit.Test;

public class VerifySequenceOfBSTAfterOrder {

    @Test
    public void test(){
        int [] a = {13,15,20,10};
        System.out.println(VerifySequenceOfBST(a));
    }

    //-----------------------------------------------------------------------------------------------

    /**
     * BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （也就是根），如果去掉最后一个元素的序列为T，那么T满足：
     * T可以分成两段，前一段（左子树）小于x，后一段（右子树）大于x，且这两段（子树）都是合法的后序序列。
     * 完美的递归定义
     *
     * @param sequence
     * @return
     */
    public boolean VerifySequenceOfBST(int [] sequence) {
        if (sequence.length == 0)
            return false;
        return judge(sequence,0,sequence.length-1);
    }

    private boolean judge(int[] sequence, int start, int end) {
        if (end - start <= 1)
            return true;
        int rightIndex = end;
        for(int i = start;i <= end - 1;i++){
            if (sequence[i] > sequence[end]){
                rightIndex = i;
                break;
            }
        }
        if (rightIndex == end)
            return true;
        for (int i = rightIndex;i <= end - 1;i++){
            if (sequence[i] < sequence[end])
                return false;
        }
        return judge(sequence,start,rightIndex - 1) && judge(sequence,rightIndex,end - 1);
    }

    //----------------------------------------------------------------------------------------------------

}
