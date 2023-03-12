import ds.TreeNode;
import ds.TreeUtil;

public class MaxPathSum {
    public static void main(String[] args) {
        System.out.println(
                new Solution124().maxPathSum(
                        TreeUtil.stringToTreeNode("[-10,9,20,null,null,15,7]")
                )
        );
    }
}

class Solution124 {
    private int max_sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return max_sum;
    }
    public int maxGain(TreeNode node){
        if(node == null){
            return 0;   //空节点的贡献为0
        }

        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);
        int totalGain = node.val + leftGain +rightGain;     //（递归）计算左右节点（子树）贡献
        if(totalGain > max_sum){    //当前节点作为路径根节点
            max_sum = totalGain;
        }

        return node.val + Math.max(leftGain, rightGain);   //向上贡献只能包含一个方向
    }
}