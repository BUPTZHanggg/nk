package bitOperation;

//一个整型数组里除了两个数字之外，其他的数字都出现了两次
// 请写程序找出这两个只出现一次的数字
public class FindTwoNumsAppearOnceInArray {

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

        //异或结果就是两个只出现一次的数字的异或结果
        int tmp = array[0];
        for (int i = 1;i < array.length;i++){
            tmp = tmp ^ array[i];
        }

        //找到异或结果的二进制表示中第一次出现1的位置
        int index = 0;
        while ((tmp & 1) == 0){
            index++;
            tmp = tmp >> 1;
        }

        //根据check的结果将数组中的数字分为两组，且将两个只出现一次的数字分开
        for (int i = 0; i < array.length; i++) {
            if (check(array[i],index)){
                num1[0] = num1[0] ^ array[i];
            }else {
                num2[0] = num2[0] ^ array[i];
            }
        }

    }

    //判断num的index位置是否为1
    private boolean check(int num, int index) {
        return ((num >> index) & 1) == 1;
    }


}
