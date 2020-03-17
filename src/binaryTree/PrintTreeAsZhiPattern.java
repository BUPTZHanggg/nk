package binaryTree;

import binaryTree.TreeNode;
import org.junit.Test;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.Stack;

public class PrintTreeAsZhiPattern {

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
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        System.out.println(Print(t1));
    }
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        int layer = 1;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        s1.push(pRoot);
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        while (!s1.empty() || !s2.empty()){
            if (layer % 2 == 1){
                ArrayList<Integer> list = new ArrayList<Integer>();
                while (!s1.empty()){
                    if (s1.peek() != null){
                        list.add(s1.peek().val);
                        s2.push(s1.peek().left);
                        s2.push(s1.peek().right);
                    }
                    s1.pop();
                }
                if (!list.isEmpty())
                    res.add(list);
                layer++;
            }else {
                ArrayList<Integer> list = new ArrayList<Integer>();
                while (!s2.empty()){
                    if (s2.peek() != null){
                        list.add(s2.peek().val);
                        s1.push(s2.peek().right);
                        s1.push(s2.peek().left);
                    }
                    s2.pop();
                }
                if (!list.isEmpty())
                    res.add(list);
                layer++;
            }
        }
        return res;
    }

}
