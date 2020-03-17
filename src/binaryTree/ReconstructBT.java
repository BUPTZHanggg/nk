package binaryTree;

public class ReconstructBT {

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || pre.length == 0)
            return null;
        return reconstruct(pre,0,pre.length - 1,in,0,in.length - 1);
    }

    private TreeNode reconstruct(int[] pre, int preLow, int preHigh, int[] in, int inLow, int inHigh) {
        if (preHigh < preLow)
            return null;
        TreeNode root = new TreeNode(pre[preLow]);
        if (preHigh == preLow)
            return root;
        int rootVal = root.val;
        int index = 0;
        for (int i = inLow;i <= inHigh;i++){
            if (in[i] == rootVal){
                index = i;
                break;
            }
        }
        int leftLen = index - inLow;
        root.left = reconstruct(pre,preLow+1,preLow+leftLen,in,inLow,index-1);
        root.right = reconstruct(pre,preLow+leftLen+1,preHigh,in,index+1,inHigh);
        return root;
    }
}
