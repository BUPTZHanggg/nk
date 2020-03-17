import binaryTree.TreeNode;
import org.junit.Test;

import java.util.Arrays;

public class SerializeBT {

    @Test
    public void test(){
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(5);
        TreeNode t7 = new TreeNode(6);
        t1.left = t2;
        t1.right = t3;
//        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        String str = Serialize(t1);
        System.out.println(str);
        TreeNode deserialize = Deserialize(str);
        System.out.println(Serialize(deserialize));
    }

    //根据二叉树的前序遍历不能重构二叉树，但是如果换一种前序遍历方式就可以了，即当节点为空时添加一个特殊字符
    String Serialize(TreeNode root) {
        StringBuffer str = new StringBuffer();
        Serialize(root, str);
        String res = str.toString();
        return res.substring(0, str.length() - 1);
    }

    private void Serialize(TreeNode root, StringBuffer str) {
        if (root == null){
            str.append("$,");
            return;
        }
        str.append(root.val + ",");
        Serialize(root.left, str);
        Serialize(root.right, str);
    }

    private int index = 0;

    TreeNode Deserialize(String str) {
        String[] strs =  str.split(",");
        System.out.println(Arrays.toString(strs));
        if (strs[0].equals("$"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        Deserialize(root, strs);
        return root;
    }

    private void Deserialize(TreeNode root, String[] strs) {
        if (index == strs.length)
            return;
        if (strs[index + 1].equals("$") && strs[index + 2].equals("$")) {
            index += 3;
            return;
        }
        if (strs[index + 1].equals("$")){
            index += 2;
        }else {
            TreeNode left = new TreeNode(Integer.parseInt(strs[++index]));
            root.left = left;
            Deserialize(left, strs);
        }
        if (!strs[index].equals("$")){
            TreeNode right = new TreeNode(Integer.parseInt(strs[index]));
            root.right = right;
            Deserialize(right, strs);
        }else {
            index++;
        }

    }


}
